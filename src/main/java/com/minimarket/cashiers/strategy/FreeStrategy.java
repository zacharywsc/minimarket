package com.minimarket.cashiers.strategy;

import com.minimarket.cashiers.Product;

/**
 * Created by Zachary on 2016/3/3.
 */
public class FreeStrategy extends AbstractStrategy {
    private FavorableStrategy favorableStrategy;
    private int conditionAmount;
    private int freeAmount;

    @Override
    public double getFavorablePrice(Product product, int amount) {
        int countAmount = countAmount(amount);
        double favorablePrice = 0;
        if (favorableStrategy != null)
            favorablePrice = favorableStrategy.getFavorablePrice(product, countAmount);
        return favorablePrice;
    }

    private int countAmount(int amount) {
        int totalAmount = conditionAmount + freeAmount;
        int extralAmount = amount % totalAmount;
        if (extralAmount > conditionAmount) {
            extralAmount = conditionAmount;
        }
        return amount / totalAmount * conditionAmount + extralAmount;
    }

    public FreeStrategy(FavorableStrategy favorableStrategy, int conditionAmount, int freeAmount) {
        this.favorableStrategy = favorableStrategy;

        this.conditionAmount = conditionAmount;
        this.freeAmount = freeAmount;
    }

    public FreeStrategy(int conditionAmount, int freeAmount) {
        this.favorableStrategy = new DefaultStrategy();
        this.conditionAmount = conditionAmount;
        this.freeAmount = freeAmount;
    }

}
