package com.minimarket.cashiers;

import com.minimarket.cashiers.strategy.DefaultStrategy;
import com.minimarket.cashiers.strategy.DiscountStrategy;
import com.minimarket.cashiers.strategy.FreeStrategy;

import java.util.LinkedList;

/**
 * Created by Zachary on 2016/3/3.
 */
public class MockUpDataUtil {
    public static final Product apple2 = new Product();
    public static final Product cola = new Product();
    public static final Product apple = new Product();
    public static final Product shuttlecocks = new Product();
    public static final Payment payment = new Payment();
    public static final String shoppingListString =
            "[\n" +
                    "    'ITEM000001',\n" +
                    "    'ITEM000001',\n" +
                    "    'ITEM000001',\n" +
                    "    'ITEM000003',\n" +
                    "    'ITEM000003-5',\n" +
                    "    'ITEM000005',\n" +
                    "    'ITEM000005',\n" +
                    "]"
            ;
    public static ShoppingList shoppingList;


    static {
        initCola(cola);
        initApple(apple);
        initApple2(apple2);
        initShuttlecocks(shuttlecocks);
        initPayment(payment);
        initShoppingList();
    }

    private static void initShuttlecocks(Product item) {
        item.setCurreny("元");
        item.setId("ITEM000003");
        item.setName("羽毛球");
        item.setMeasurement("个");
        item.setPrice(1);
        item.setFavourableStrategy(new FreeStrategy(2,1));
    }

    private static void initShoppingList() {
        try {
            shoppingList = new ShoppingList(shoppingListString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initApple(Product item) {
        item.setCurreny("元");
        item.setId("ITEM000005");
        item.setName("苹果");
        item.setMeasurement("斤");
        item.setPrice(5.5);
        item.setFavourableStrategy(new DiscountStrategy(0.95));
    }

    private static void initApple2(Product item) {
        item.setCurreny("元");
        item.setId("ITEM000005");
        item.setName("苹果");
        item.setPrice(5.5);
        item.setMeasurement("斤");
        item.setFavourableStrategy(DefaultStrategy.getDefaultStrategy());

    }

    private static void initCola(Product cola) {
        cola.setCurreny("元");
        cola.setId("ITEM000001");
        cola.setName("可口可乐");
        cola.setMeasurement("瓶");
        cola.setPrice(3);
        cola.setFavourableStrategy(new FreeStrategy(2,1));
    }

    private static void initPayment(Payment payment) {
        payment.currency = "元";
        payment.discount = 5.550000000000001;
        payment.total = 20.45;
        payment.payItems = new LinkedList<Payment.PayItem>();
        payment.payItems.add(buildShoppingItem1());
        payment.payItems.add(buildShoppingItem2());
        payment.payItems.add(buildShoppingItem3());
        payment.discountItems = new LinkedList<Payment.DiscountItem>();
        payment.discountItems.add(buildDiscountItem1());
        payment.discountItems.add(buildDiscountItem2());

    }

    private static Payment.PayItem buildShoppingItem1() {
        Payment.PayItem payItem = new Payment.PayItem();
        payItem.name = "可口可乐";
        payItem.measurement = "瓶";
        payItem.discount = 0;
        payItem.amount = 3;
        payItem.total = 6;
        payItem.price = 3;
        return payItem;
    }

    private static Payment.PayItem buildShoppingItem2() {
        Payment.PayItem payItem = new Payment.PayItem();
        payItem.name = "羽毛球";
        payItem.measurement = "个";
        payItem.discount = 0;
        payItem.amount = 6;
        payItem.total = 4.00;
        payItem.price = 1;
        return payItem;
    }

    private static Payment.PayItem buildShoppingItem3() {
        Payment.PayItem payItem = new Payment.PayItem();
        payItem.name = "苹果";
        payItem.measurement = "斤";
        payItem.discount = 0.5500000000000007;
        payItem.amount = 2;
        payItem.total = 10.45;
        payItem.price = 5.5;
        return payItem;
    }

    private static Payment.DiscountItem buildDiscountItem1() {
        Payment.DiscountItem item = new Payment.DiscountItem();
        item.name = "可口可乐";
        item.measurement = "瓶";
        item.amount = 1;
        item.strategy = "free|2|1";
        return item;
    }

    private static Payment.DiscountItem buildDiscountItem2() {
        Payment.DiscountItem item = new Payment.DiscountItem();
        item.name = "羽毛球";
        item.measurement = "个";
        item.amount = 2;
        item.strategy = "free|2|1";
        return item;
    }

    public static Payment getMockUpPayment1(){
        return payment;
    }
}
