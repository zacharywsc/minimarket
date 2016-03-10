package com.minimarket.cashiers.printer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minimarket.cashiers.Config;
import com.minimarket.cashiers.Payment;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by Zachary on 2016/3/3.
 */
public class ConsolePrinter implements Printer {
    ExecutorService countingThreadPool = Executors.newFixedThreadPool(10);
    Logger logger = Logger.getLogger(ConsolePrinter.class);

//    private Config  config = new Config();
    private Configuration freeMarkConfig;

    public ConsolePrinter(){
        init();
    }

    public void init(){
        freeMarkConfig = new Configuration();
        freeMarkConfig.setDefaultEncoding("utf-8");
        freeMarkConfig.setClassForTemplateLoading(this.getClass(),"/");
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
        String result = getFormatString(payment);
        System.out.print(result);
        return result;
    }

    private String getFormatString(Payment payment) {
        Template t = null;
        try {
//            String templateFileName = config.getValue("format");
            t = freeMarkConfig.getTemplate("printer.ftl");

        } catch (IOException e) {
            logger.error("can't open format file",e);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> paymentMap = objectMapper.convertValue(payment,Map.class);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
            t.process(paymentMap, outputStreamWriter);
            String result = new String(byteArrayOutputStream.toByteArray(),"UTF-8");
            return result;
        } catch (TemplateException e) {
            logger.error("processing with format error",e);
        } catch (IOException e) {
            logger.error("processing with format IO error",e);
        }
        return "";
    }
}
