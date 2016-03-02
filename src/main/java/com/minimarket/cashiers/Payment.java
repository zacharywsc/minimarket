package com.minimarket.cashiers;

import java.util.List;

/**
 * Created by Zachary on 2016/3/2.
 */
public class Payment {
    private static class ShoppingItem{
        String name;
        String measurement;
        Integer amount;
        double totol;
        double discount;
    }
    private static class DiscountItem{
        String name;
        String measurement;
        int amount;
    }

    public double total;
    public double discount;
    public String curreny;
    public List<ShoppingItem> shoppingItems;
    public List<DiscountItem> discountItems;

}
