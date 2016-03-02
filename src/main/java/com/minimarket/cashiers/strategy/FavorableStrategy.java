package com.minimarket.cashiers.strategy;

/**
 * Created by Zachary on 2016/3/2.
 */
public interface FavorableStrategy {
    double getFavorablePrice(int amount);
    double getOrginalPrice(int amount);
    double getDeviation(int amount);

}
