package com.minimarket.cashiers;

import com.minimarket.cashiers.strategy.FavorableStrategy;

/**
 * Created by Zachary on 2016/3/2.
 */
public class Product {
    private String id;
    private String name;
    private double price;
    private String curreny;
    private FavorableStrategy favourableStrategy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurreny() {
        return curreny;
    }

    public void setCurreny(String curreny) {
        this.curreny = curreny;
    }

    public FavorableStrategy getFavourableStrategy() {
        return favourableStrategy;
    }

    public void setFavourableStrategy(FavorableStrategy favourableStrategy) {
        this.favourableStrategy = favourableStrategy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.price, price) != 0) return false;
        if (!id.equals(product.id)) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (curreny != null ? !curreny.equals(product.curreny) : product.curreny != null) return false;
        return favourableStrategy != null ? favourableStrategy.equals(product.favourableStrategy) : product.favourableStrategy == null;

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
