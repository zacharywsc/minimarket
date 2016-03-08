package com.minimarket.cashiers.strategy;

import com.minimarket.cashiers.Product;
import com.minimarket.cashiers.ShoppingList;

/**
 * Created by Zachary on 2016/3/3.
 */
public abstract class AbstractStrategy implements FavorableStrategy {


    public double getOrginalPrice(ShoppingList.ShoppingItem shoppingItem) {
        return DefaultStrategy.getDefaultStrategy().getFavorablePrice(shoppingItem);
    }

    public double getDeviation(ShoppingList.ShoppingItem shoppingItem) {
        return getOrginalPrice(shoppingItem) - getFavorablePrice(shoppingItem);
    }

    public int getUnCountingAmount(ShoppingList.ShoppingItem shoppingItem){
        return 0;
    }


}
