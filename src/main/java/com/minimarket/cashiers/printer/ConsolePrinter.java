package com.minimarket.cashiers.printer;

import com.minimarket.cashiers.Payment;
import org.apache.log4j.Logger;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Zachary on 2016/3/3.
 */
public class ConsolePrinter implements Printer {
    ExecutorService countingThreadPool = Executors.newFixedThreadPool(10);
    Logger logger = Logger.getLogger(ConsolePrinter.class);

    public Future<String> print(Future<Payment> paymentFuture) {
        return null;
    }

    public String printToConsole(Future<Payment> paymentFuture) {
        Payment payment = null;
        try {
            payment = paymentFuture.get();
        } catch (InterruptedException e) {
            logger.error("The counting had been Interrupted", e);
        } catch (ExecutionException e) {
            logger.error("The counting had ExecutionException", e);
        }
        String format = formatPayment(payment);
        System.out.print(format);
        return format;

    }

    private String formatPayment(Payment payment) {
        if (payment == null) return "";
        return null;
    }
}
