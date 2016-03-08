package com.minimarket.cashiers;

import com.minimarket.cashiers.printer.ConsolePrinter;
import com.minimarket.cashiers.printer.Printer;
import com.minimarket.cashiers.service.CountService;
import com.minimarket.cashiers.service.CountServiceImpl;

import java.util.concurrent.Future;

/**
 * Created by Zachary on 2016/3/3.
 */
public class CashierImpl implements Cashier{

    CountService countService = new CountServiceImpl();
    Printer printer = new ConsolePrinter();

    public Future<String> printShoppingDetail(ShoppingList shoppingList) {
        Future<Payment> paymentFuture = countService.count(shoppingList);
        return printer.print(paymentFuture);
    }

    public Future<String> printShoppingDetail(String shoppingListString) {
        ShoppingList shoppingList = new ShoppingList(shoppingListString);
        return printShoppingDetail(shoppingList);
    }
}
