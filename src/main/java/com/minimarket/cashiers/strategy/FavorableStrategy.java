package com.minimarket.cashiers.strategy;

import com.minimarket.cashiers.Product;

/**
 * Created by Zachary on 2016/3/2.
 */
public interface FavorableStrategy {
    double getFavorablePrice(Product product, int amount);
    double getOrginalPrice(Product product, int amount);
    double getDeviation(Product product, int amount);

}
