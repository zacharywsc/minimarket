package com.minimarket.cashiers.strategy;

import com.minimarket.cashiers.MockUpDataUtil;
import com.minimarket.cashiers.Product;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Zachary on 2016/3/3.
 */
public class FreeStrategyTest {

    @Test
    public void testGetFavorablePrice() throws Exception {
        Product product = MockUpDataUtil.cola;
        double favorablePrice = product.getFavourableStrategy().getFavorablePrice(product, 3);
        assertEquals(6,favorablePrice,0);
    }
}