package com.minimarket.cashiers.strategy;

import com.minimarket.cashiers.Product;

/**
 * Created by Zachary on 2016/3/2.
 */
public class DefaultStrategy implements FavorableStrategy {
    Product product;

    public double getFavorablePrice(int amount) {
        return 0;
    }

    public double getOrginalPrice(int amount) {
        return 0;
    }

    public double getDeviation(int amount) {
        return 0;
    }
}
