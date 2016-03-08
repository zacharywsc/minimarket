package com.minimarket.cashiers.printer;

import com.minimarket.cashiers.Payment;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Zachary on 2016/3/3.
 */
public class ConsolePrinter implements Printer {
    ExecutorService countingThreadPool = Executors.newFixedThreadPool(10);

    public Future<String> print(Future<Payment> paymentFuture) {
        return null;
    }

    public String printToConsole(Future<Payment> paymentFuture) throws ExecutionException, InterruptedException {
        Payment payment = paymentFuture.get();
        String format = formatPayment();
        System.out.print(format);
        return format;

    }

    private String formatPayment() {
        return null;
    }
}
