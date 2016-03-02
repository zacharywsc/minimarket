package com.minimarket.cashiers.printer;

import com.minimarket.cashiers.Payment;

import java.util.concurrent.Future;

/**
 * Created by Zachary on 2016/3/3.
 */
public class ConsolePrinter implements Printer {
    public Future<String> print(Payment payment) {
        return null;
    }
}
