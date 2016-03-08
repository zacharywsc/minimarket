package com.minimarket.cashiers.strategy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minimarket.cashiers.Product;
import com.minimarket.cashiers.ShoppingList;

/**
 * Created by Zachary on 2016/3/3.
 */
public class DiscountStrategy extends AbstractStrategy {
    private double discount;
    @JsonIgnore
    private  FavorableStrategy favorableStrategy;
    public static final String name = "discount";

    public DiscountStrategy(double discount, FavorableStrategy favorableStrategy) {
        this.discount = discount;
        this.favorableStrategy = favorableStrategy;
    }

    public DiscountStrategy(double discount) {
        this.favorableStrategy = DefaultStrategy.getDefaultStrategy();
        this.discount = discount;
    }


    public double getFavorablePrice(ShoppingList.ShoppingItem shoppingItem) {
        double favorablePrice = 0;
        if (favorableStrategy != null)
            favorablePrice = favorableStrategy.getFavorablePrice(shoppingItem);
        return favorablePrice*discount;
    }

    public String getName() {
        return name;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public FavorableStrategy getFavorableStrategy() {
        return favorableStrategy;
    }

    public void setFavorableStrategy(FavorableStrategy favorableStrategy) {
        this.favorableStrategy = favorableStrategy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiscountStrategy that = (DiscountStrategy) o;

        if (Double.compare(that.discount, discount) != 0) return false;
        return favorableStrategy != null ? favorableStrategy.equals(that.favorableStrategy) : that.favorableStrategy == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(discount);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (favorableStrategy != null ? favorableStrategy.hashCode() : 0);
        return result;
    }
}
