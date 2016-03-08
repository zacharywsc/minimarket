package com.minimarket.cashiers;

import com.minimarket.cashiers.strategy.FavorableStrategy;

/**
 * Created by Zachary on 2016/3/2.
 */
public class Product implements Comparable<Product> {
    private String id;
    private String name;
    private double price;
    private String curreny;
    private String measurement;
    private FavorableStrategy favourableStrategy;

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

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
        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (curreny != null ? !curreny.equals(product.curreny) : product.curreny != null) return false;
        if (measurement != null ? !measurement.equals(product.measurement) : product.measurement != null) return false;
        return favourableStrategy != null ? favourableStrategy.equals(product.favourableStrategy) : product.favourableStrategy == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (curreny != null ? curreny.hashCode() : 0);
        result = 31 * result + (measurement != null ? measurement.hashCode() : 0);
        result = 31 * result + (favourableStrategy != null ? favourableStrategy.hashCode() : 0);
        return result;
    }

    public int compareTo(Product product) {
        return this.name.compareTo(product.name);
    }
}
