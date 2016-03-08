package com.minimarket.cashiers.service;

import com.minimarket.cashiers.Payment;
import com.minimarket.cashiers.Product;
import com.minimarket.cashiers.ShoppingList;
import com.minimarket.cashiers.strategy.DiscountStrategy;
import com.minimarket.cashiers.strategy.FavorableStrategy;
import com.minimarket.cashiers.strategy.FreeStrategy;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Zachary on 2016/3/9.
 */
public class CountingUnit {
    private List<ShoppingList.ShoppingItem> list;
    private Iterator<ShoppingList.ShoppingItem> itemIterator;
    private ShoppingList.ShoppingItem current;
    private Product product;
    private FavorableStrategy strategy;
    private int amount;
    private double total;
    private double discount;
    private String currency;

    public CountingUnit(ShoppingList list) {
        this.list = list.getShoppingListDetail();
        itemIterator = this.list.iterator();

    }

    public String getCurrency() {
        return currency;
    }

    public double getTotal() {
        return total;
    }

    public double getDiscount() {
        return discount;
    }

    public boolean hasNext() {
        return itemIterator.hasNext();
    }

    public void next() {
        current = itemIterator.next();
        product = current.getProduct();
        strategy = product.getFavourableStrategy();
        amount = current.getAmount();
        currency = product.getCurreny();
    }

    public Payment.DiscountItem createDiscountItem() {
        FavorableStrategy strategy = product.getFavourableStrategy();
        if (strategy.getName().startsWith(FreeStrategy.name)) {
            Payment.DiscountItem discountItem = new Payment.DiscountItem();
            discountItem.amount = strategy.getUnCountingAmount(current);
            discountItem.name = product.getName();
            discountItem.strategy = strategy.getName();
            discountItem.measurement = product.getMeasurement();
            return discountItem;
        }
        return null;
    }

    public Payment.PayItem createShoppingItem() {
        Payment.PayItem payItem = new Payment.PayItem();
        payItem.name = product.getName();
        payItem.amount = amount;
        discount = strategy.getDeviation(current);
        if (strategy.getName() == DiscountStrategy.name) {
            payItem.discount = discount;
        }
        payItem.measurement = product.getMeasurement();
        payItem.price = product.getPrice();
        total = strategy.getFavorablePrice(current);
        payItem.totol = total;
        return payItem;
    }
}
