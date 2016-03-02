package com.minimarket.cashiers.provider;

import com.minimarket.cashiers.MockUpDataUtil;
import com.minimarket.cashiers.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Zachary on 2016/3/3.
 */
public class DBProviderTest {

    private DBProvider dbProvider;


    @Before
    public void setup() {
        dbProvider = new MockDBProvider();

    }

    @Test
    public void testGetProduct() throws Exception {
        Product product = dbProvider.getProduct("ITEM000001");
        assertEquals(MockUpDataUtil.cola, product);
    }
}