package com.minimarket.cashiers;

import com.minimarket.cashiers.Exception.ProductNotFindException;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Zachary on 2016/3/2.
 */
public class ShoppingList {
    Map<Product, Integer> map = new TreeMap<Product, Integer>();

    public ShoppingList(Map<Product, Integer> map) {
        this.map = map;
    }

    public ShoppingList(String list) {
        this.map = map;
    }

    public ShoppingList() {

    }

    void put(Product product) {
        put(product, 1);
    }

    void put(Product product, int amount) {
        Integer integer = map.get(product);
        if (integer == null) {
            integer = amount;
        } else {
            integer += amount;
        }
        map.put(product, integer);
    }

    void delete(Product product, int amount) throws ProductNotFindException {
        Integer integer = map.get(product);
        if (integer == null) {
            throw new ProductNotFindException();
        } else {
            integer -= amount;
        }
        if (integer <= 0) {
            deleteProdcut(product);
        } else {
            map.put(product, integer);
        }

    }

    void deleteProdcut(Product product) {
        map.remove(product);
    }
}
