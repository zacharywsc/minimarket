package com.minimarket.cashiers;

import com.minimarket.cashiers.Exception.ProductNotFindException;
import com.minimarket.cashiers.provider.MockProductProvider;
import com.minimarket.cashiers.provider.ProductProvider;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Created by Zachary on 2016/3/2.
 */
public class ShoppingList {

    Logger logger = Logger.getLogger(ShoppingList.class);

    private static AtomicInteger idGenerator = new AtomicInteger(0);

    private Map<Product, Integer> map = new TreeMap<Product, Integer>();

    private int id;

    private ProductProvider productProvider = new MockProductProvider();

    public ShoppingList(Map<Product, Integer> map) {
        this.map = map;
    }

    public int getId() {
        return id;
    }

    static public class ShoppingItem {
        private Product product;
        private int amount;

        public ShoppingItem(Product product, int amount) {
            this.product = product;
            this.amount = amount;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }

    public List<ShoppingItem> getShoppingListDetail() {
        List<ShoppingItem> list = new ArrayList<ShoppingItem>(map.keySet().size());
        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
            ShoppingItem shoppingItem = new ShoppingItem(entry.getKey(), entry.getValue());
            list.add(shoppingItem);
        }
        return list;

    }

    public ShoppingList(String list) throws Exception {
        this.id = idGenerator.getAndIncrement();
        List<String> rawStringList = readRawStringList(list);
        for (String item : rawStringList) {
            putStringItem(item);
        }
    }

    private List<String> readRawStringList(String list) {
        List<String> rawStringList = new LinkedList<String>();
        String[] array = list.split("\n");
        for (String item : array) {
            String[] itemDetail = item.split("\'");
            if (itemDetail.length > 1) {
                rawStringList.add(itemDetail[1]);
            }
        }
        return rawStringList;

    }


    private void putStringItem(String item) {
        String[] itemDetails = item.split("-");
        Product product = null;
        try {
            product = productProvider.getProduct(itemDetails[0]);
        } catch (ProductNotFindException e) {
            logger.error("can't find product "+itemDetails[0],e);
        }
        if (itemDetails.length > 1) {
            int amount = Integer.parseInt(itemDetails[1]);
            put(product, amount);
        } else {
            put(product);
        }
    }

    public ShoppingList() {
        this.id = idGenerator.getAndIncrement();
    }

    void put(Product product) {
        put(product, 1);
    }

    void put(Product product, int amount) {
        Integer integer = map.get(product);
        if (integer == null) {
            integer = amount;
        } else {
            integer += amount;
        }
        map.put(product, integer);
    }

    void delete(Product product, int amount) throws ProductNotFindException {
        Integer integer = map.get(product);
        if (integer == null) {
            throw new ProductNotFindException(product.getId());
        } else {
            integer -= amount;
        }
        if (integer <= 0) {
            deleteProdcut(product);
        } else {
            map.put(product, integer);
        }

    }

    void deleteProdcut(Product product) {
        map.remove(product);
    }
}
