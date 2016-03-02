package com.minimarket.cashiers.strategy;

import com.minimarket.cashiers.Product;

/**
 * Created by Zachary on 2016/3/3.
 */
public abstract class AbstractStrategy implements FavorableStrategy {



    public abstract double getFavorablePrice(Product product, int amount);

    public double getOrginalPrice(Product product, int amount) {
        return product.getPrice()*amount;
    }

    public double getDeviation(Product product, int amount) {
        return getOrginalPrice(product, amount) - getFavorablePrice(product, amount);
    }


}
