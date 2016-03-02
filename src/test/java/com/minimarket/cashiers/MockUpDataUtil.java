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
    public static final Payment payment = new Payment();
    public static final String shoppingListString =
            "[\n" +
                    "    'ITEM000001',\n" +
                    "    'ITEM000001',\n" +
                    "    'ITEM000001',\n" +
                    "    'ITEM000001',\n" +
                    "    'ITEM000001',\n" +
                    "    'ITEM000003-2',\n" +
                    "    'ITEM000005',\n" +
                    "    'ITEM000005',\n" +
                    "    'ITEM000005'\n" +
                    "]"
            ;
    public static final ShoppingList shoppingList = new ShoppingList(shoppingListString);


    static {
        initCola(cola);
        initApple(apple);
        initApple2(apple2);
        initPayment(payment);

    }

    private static void initApple(Product item) {
        item.setCurreny("斤");
        item.setId("ITEM000005");
        item.setName("苹果");
        item.setPrice(5.5);
        item.setFavourableStrategy(new DiscountStrategy(0.95));
    }

    private static void initApple2(Product item) {
        item.setCurreny("斤");
        item.setId("ITEM000005");
        item.setName("苹果");
        item.setPrice(5.5);
        item.setFavourableStrategy(new DefaultStrategy());

    }

    private static void initCola(Product cola) {
        cola.setCurreny("元");
        cola.setId("ITEM000001");
        cola.setName("可乐");
        cola.setPrice(3);
        cola.setFavourableStrategy(new FreeStrategy(2,1));
    }

    private static void initPayment(Payment payment) {
        payment.curreny = "元";
        payment.discount = 5.55;
        payment.total = 20.45;
        payment.shoppingItems = new LinkedList<Payment.ShoppingItem>();
        payment.shoppingItems.add(buildShoppingItem1());
        payment.shoppingItems.add(buildShoppingItem2());
        payment.shoppingItems.add(buildShoppingItem3());
        payment.discountItems = new LinkedList<Payment.DiscountItem>();
        payment.discountItems.add(buildDiscountItem1());
        payment.discountItems.add(buildDiscountItem2());

    }

    private static Payment.ShoppingItem buildShoppingItem1() {
        Payment.ShoppingItem shoppingItem = new Payment.ShoppingItem();
        shoppingItem.name = "可口可乐";
        shoppingItem.measurement = "瓶";
        shoppingItem.discount = 0;
        shoppingItem.amount = 3;
        shoppingItem.totol = 6;
        shoppingItem.price = 3;
        return shoppingItem;
    }

    private static Payment.ShoppingItem buildShoppingItem2() {
        Payment.ShoppingItem shoppingItem = new Payment.ShoppingItem();
        shoppingItem.name = "羽毛球";
        shoppingItem.measurement = "个";
        shoppingItem.discount = 0;
        shoppingItem.amount = 6;
        shoppingItem.totol = 4.00;
        shoppingItem.price = 1;
        return shoppingItem;
    }

    private static Payment.ShoppingItem buildShoppingItem3() {
        Payment.ShoppingItem shoppingItem = new Payment.ShoppingItem();
        shoppingItem.name = "苹果";
        shoppingItem.measurement = "斤";
        shoppingItem.discount = 0.55;
        shoppingItem.amount = 2;
        shoppingItem.totol = 10.45;
        shoppingItem.price = 5.5;
        return shoppingItem;
    }

    private static Payment.DiscountItem buildDiscountItem1() {
        Payment.DiscountItem item = new Payment.DiscountItem();
        item.name = "可口可乐";
        item.measurement = "瓶";
        item.amount = 1;
        item.strategy = "买二赠一";
        return item;
    }

    private static Payment.DiscountItem buildDiscountItem2() {
        Payment.DiscountItem item = new Payment.DiscountItem();
        item.name = "羽毛球";
        item.measurement = "个";
        item.amount = 2;
        item.strategy = "买二赠一";
        return item;
    }

    public static Payment getMockUpPayment1(){
        return payment;
    }
}
