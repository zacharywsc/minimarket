package com.minimarket.cashiers;

import com.minimarket.cashiers.service.CountService;

import java.util.concurrent.Future;

/**
 * Created by Zachary on 2016/3/2.
 */
public interface Cashier {
    Future<String> printShoppingDetail(ShoppingList shoppingList);
    Future<String> printShoppingDetail(String shoppingListString);
}
