package com.minimarket.cashiers.service;

import com.minimarket.cashiers.Payment;
import com.minimarket.cashiers.ShoppingList;

import java.util.concurrent.Future;

/**
 * Created by Zachary on 2016/3/2.
 */
public interface CountService {
    Future<Payment> count(ShoppingList shoppingList);
}
