package com.minimarket.cashiers.printer;

import com.minimarket.cashiers.MockUpDataUtil;
import com.minimarket.cashiers.Payment;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;

/**
 * Created by Zachary on 2016/3/3.
 */
public class PrinterTest {

    private Printer printer;

    private Payment payment;

    static private final String except = "***<没钱赚商店>购物清单***\n" +
            "名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：6.00(元)\n" +
            "名称：羽毛球，数量：6个，单价：1.00(元)，小计：4.00(元)\n" +
            "名称：苹果，数量：2斤，单价：5.50(元)，小计：10.45(元)，节省0.55(元)\n" +
            "----------------------\n" +
            "买二赠一商品：\n" +
            "名称：可口可乐，数量：1瓶\n" +
            "名称：羽毛球，数量：2个\n" +
            "----------------------\n" +
            "总计：20.45(元)\n" +
            "节省：5.55(元)\n" +
            "**********************";

    @Before
    public void setup() {
        initPrinter();
        payment = MockUpDataUtil.getMockUpPayment1();
    }

    private void initPrinter() {
        printer = new ConsolePrinter();
    }



    @Test
    public void testPrint() throws ExecutionException, InterruptedException {
        Future<String> printStringFuture = printer.print(new Future<Payment>() {
            public boolean cancel(boolean mayInterruptIfRunning) {
                return false;
            }

            public boolean isCancelled() {
                return false;
            }

            public boolean isDone() {
                return false;
            }

            public Payment get() throws InterruptedException, ExecutionException {
                return MockUpDataUtil.payment;
            }

            public Payment get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return MockUpDataUtil.payment;
            }
        });
        String actual = printStringFuture.get();
        assertEquals(except,actual);
    }

}