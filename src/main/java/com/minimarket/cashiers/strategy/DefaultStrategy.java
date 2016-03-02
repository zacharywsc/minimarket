package com.minimarket.cashiers.strategy;

import com.minimarket.cashiers.Product;

/**
 * Created by Zachary on 2016/3/2.
 */
public class DefaultStrategy extends AbstractStrategy {


    public double getFavorablePrice(Product product, int amount) {
        return product.getPrice()*amount;
    }

}
