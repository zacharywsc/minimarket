package com.minimarket.cashiers.strategy;

import com.minimarket.cashiers.MockUpDataUtil;
import com.minimarket.cashiers.Product;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Zachary on 2016/3/3.
 */
public class DiscountStrategyTest {

    @Test
    public void testGetFavorablePrice() throws Exception {
        Product product = MockUpDataUtil.apple;
        double favorablePrice = product.getFavourableStrategy().getFavorablePrice(product, 2);
        assertEquals(10.45,favorablePrice,0);
    }
}