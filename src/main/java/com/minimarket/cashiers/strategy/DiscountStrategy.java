package com.minimarket.cashiers.strategy;

import com.minimarket.cashiers.Product;

/**
 * Created by Zachary on 2016/3/3.
 */
public class DiscountStrategy extends AbstractStrategy {
    private double discount;
    private  FavorableStrategy favorableStrategy;

    public DiscountStrategy(double discount, FavorableStrategy favorableStrategy) {
        this.discount = discount;
        this.favorableStrategy = favorableStrategy;
    }

    public DiscountStrategy(double discount) {
        this.favorableStrategy = new DefaultStrategy();
        this.discount = discount;
    }

    @Override
    public double getFavorablePrice(Product product, int amount) {
        double favorablePrice = 0;
        if (favorableStrategy != null)
            favorablePrice = favorableStrategy.getFavorablePrice(product, amount);
        return favorablePrice*discount;
    }
}
