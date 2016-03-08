package com.minimarket.cashiers.strategy;

import com.minimarket.cashiers.Product;
import com.minimarket.cashiers.ShoppingList;

import java.util.StringJoiner;

/**
 * Created by Zachary on 2016/3/3.
 */
public class FreeStrategy extends AbstractStrategy {

    private FavorableStrategy favorableStrategy;
    private int conditionAmount;
    private int freeAmount;
    public static final String name = "free";


    public double getFavorablePrice(ShoppingList.ShoppingItem shoppingItem) {
        int amount = shoppingItem.getAmount();
        int countAmount = countAmount(amount);
        double favorablePrice = 0;
        if (favorableStrategy != null) {
            ShoppingList.ShoppingItem actualShoppingItem = new ShoppingList.ShoppingItem(shoppingItem.getProduct(),countAmount);
            favorablePrice = favorableStrategy.getFavorablePrice(actualShoppingItem);
        }
        return favorablePrice;
    }

    public String getName() {
        return String.join("|",name,String.valueOf(conditionAmount),String.valueOf(freeAmount));
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
        this.favorableStrategy = DefaultStrategy.getDefaultStrategy();
        this.conditionAmount = conditionAmount;
        this.freeAmount = freeAmount;
    }

    public FavorableStrategy getFavorableStrategy() {
        return favorableStrategy;
    }

    public void setFavorableStrategy(FavorableStrategy favorableStrategy) {
        this.favorableStrategy = favorableStrategy;
    }

    public int getConditionAmount() {
        return conditionAmount;
    }

    public void setConditionAmount(int conditionAmount) {
        this.conditionAmount = conditionAmount;
    }

    public int getFreeAmount() {
        return freeAmount;
    }

    public void setFreeAmount(int freeAmount) {
        this.freeAmount = freeAmount;
    }

    @Override
    public int getUnCountingAmount(ShoppingList.ShoppingItem shoppingItem){
        return shoppingItem.getAmount() - countAmount(shoppingItem.getAmount());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FreeStrategy that = (FreeStrategy) o;

        if (conditionAmount != that.conditionAmount) return false;
        if (freeAmount != that.freeAmount) return false;
        return favorableStrategy != null ? favorableStrategy.equals(that.favorableStrategy) : that.favorableStrategy == null;

    }

    @Override
    public int hashCode() {
        int result = favorableStrategy != null ? favorableStrategy.hashCode() : 0;
        result = 31 * result + conditionAmount;
        result = 31 * result + freeAmount;
        return result;
    }
}
