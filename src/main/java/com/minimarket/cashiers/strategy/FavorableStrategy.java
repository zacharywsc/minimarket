package com.minimarket.cashiers.strategy;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.minimarket.cashiers.ShoppingList;
import com.minimarket.cashiers.strategy.deserializer.StrategyDeserializer;

/**
 * Created by Zachary on 2016/3/2.
 */
@JsonDeserialize(using = StrategyDeserializer.class)
public interface FavorableStrategy {
    double getFavorablePrice(ShoppingList.ShoppingItem shoppingItem);

    double getOrginalPrice(ShoppingList.ShoppingItem shoppingItem);

    double getDeviation(ShoppingList.ShoppingItem shoppingItem);

    int getUnCountingAmount(ShoppingList.ShoppingItem shoppingItem);

    String getName();
}
