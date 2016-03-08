package com.minimarket.cashiers.service;

import com.minimarket.cashiers.Payment;
import com.minimarket.cashiers.Product;
import com.minimarket.cashiers.ShoppingList;
import com.minimarket.cashiers.strategy.DiscountStrategy;
import com.minimarket.cashiers.strategy.FavorableStrategy;
import com.minimarket.cashiers.strategy.FreeStrategy;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by Zachary on 2016/3/3.
 */
public class CountServiceImpl implements CountService {


    ExecutorService countingThreadPool = Executors.newFixedThreadPool(4);

    public Future<Payment> count(final ShoppingList shoppingList) {
        return countingThreadPool.submit(new Callable<Payment>() {
            public Payment call() throws Exception {
                return countPayment(shoppingList);
            }
        });
    }

    private Payment countPayment(ShoppingList shoppingList) {
        Payment payment = new Payment();
        CountingUnit countingUnit = new CountingUnit(shoppingList);
        while (countingUnit.hasNext()) {
            countingUnit.next();
            payment.payItems.add(countingUnit.createShoppingItem());
            Payment.DiscountItem discountItem = countingUnit.createDiscountItem();
            if (discountItem != null) {
                payment.discountItems.add(discountItem);
            }
            payment.discount += countingUnit.getDiscount();
            payment.total += countingUnit.getTotal();
        }
        return payment;
    }


}
