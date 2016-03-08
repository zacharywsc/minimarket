package com.minimarket.cashiers.strategy;

import com.minimarket.cashiers.Product;
import com.minimarket.cashiers.ShoppingList;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;

/**
 * Created by Zachary on 2016/3/2.
 */
public class DefaultStrategy extends AbstractStrategy {


    public static final String name = "default";
    static DefaultStrategy strategy = new DefaultStrategy();

    public static DefaultStrategy getDefaultStrategy(){
        return strategy;
    }

    public double getFavorablePrice(ShoppingList.ShoppingItem shoppingItem) {
        Product product = shoppingItem.getProduct();
        double price = product.getPrice();
        int amount = shoppingItem.getAmount();
        return price*amount;
    }
    private DefaultStrategy(){}

    public String getName() {
        return name;
    }

}
