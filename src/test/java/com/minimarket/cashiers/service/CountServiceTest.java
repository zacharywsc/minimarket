package com.minimarket.cashiers.service;

import com.minimarket.cashiers.MockUpDataUtil;
import com.minimarket.cashiers.Payment;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Future;

import static org.junit.Assert.*;

/**
 * Created by Zachary on 2016/3/3.
 */
public class CountServiceTest {

    private CountService countService;
    @Before
    public void setup(){
        countService = new CountServiceImpl();
    }
    @Test
    public void testCount() throws Exception {
        Future<Payment> paymentFuture = countService.count(MockUpDataUtil.shoppingList);
        Payment actualPayment = paymentFuture.get();
        assertEquals(MockUpDataUtil.payment,actualPayment);

    }

}