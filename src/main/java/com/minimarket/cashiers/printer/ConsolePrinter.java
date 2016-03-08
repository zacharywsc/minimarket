package com.minimarket.cashiers.printer;

import com.minimarket.cashiers.Payment;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.concurrent.*;

/**
 * Created by Zachary on 2016/3/3.
 */
public class ConsolePrinter implements Printer {
    ExecutorService countingThreadPool = Executors.newFixedThreadPool(10);
    Logger logger = Logger.getLogger(ConsolePrinter.class);

    private Configuration configuration;

    public ConsolePrinter(){
        init();
    }

    public void init(){
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassForTemplateLoading(this.getClass(),"");
    }

    public Future<String> print(final Future<Payment> paymentFuture) {
        return countingThreadPool.submit(new Callable<String>() {
            public String call() throws Exception {
                return printToConsole(paymentFuture);
            }
        });
    }

    public String printToConsole(Future<Payment> paymentFuture) {
        Payment payment = null;
        try {
            payment = paymentFuture.get(3,TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            logger.error("The counting had been Interrupted", e);
        } catch (ExecutionException e) {
            logger.error("The counting had ExecutionException", e);
        } catch (TimeoutException e) {
            logger.error("The counting could not be completed", e);
        }
        logger.info("starting format payment: "+payment.id);
        String format = formatPayment(payment);
        System.out.print(format);
        return format;

    }

    private String formatPayment(Payment payment) {
        if (payment == null) return "";
        Template t = null;
        try {
            t = configuration.getTemplate("printer.ftl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String,Object> bitch = new HashMap<String, Object>();
        bitch.put("name","123");
        StringBuffer buffer = new StringBuffer("test");
        try {
            t.process(bitch,new OutputStreamWriter(System.out));
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
