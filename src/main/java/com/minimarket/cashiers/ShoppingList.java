package com.minimarket.cashiers;

import com.minimarket.cashiers.Exception.ProductNotFindException;
import com.minimarket.cashiers.provider.ProductProvider;
import com.minimarket.cashiers.provider.MockProductProvider;

import java.util.*;

/**
 * Created by Zachary on 2016/3/2.
 */
public class ShoppingList {
    private Map<Product, Integer> map = new TreeMap<Product, Integer>();

    private ProductProvider productProvider = new MockProductProvider();

    public ShoppingList(Map<Product, Integer> map) {
        this.map = map;
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
            System.out.print("Product " + itemDetails[0] + " Not find");
            e.printStackTrace();
        }
        if (itemDetails.length > 1) {
            int amount = Integer.parseInt(itemDetails[1]);
            put(product, amount);
        } else {
            put(product);
        }
    }

    public ShoppingList() {

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
            throw new ProductNotFindException();
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
