package com.minimarket.cashiers.strategy;

import com.minimarket.cashiers.MockUpDataUtil;
import com.minimarket.cashiers.Product;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Zachary on 2016/3/3.
 */
public class DefaultStrategyTest {


    @Test
    public void testGetFavorablePrice() throws Exception {
        Product product = MockUpDataUtil.apple2;
        double favorablePrice = product.getFavourableStrategy().getFavorablePrice(product, 10);
        assertEquals(55d, favorablePrice, 0);

    }

    @Test
    public void testGetOrignalPrice() throws Exception {
        Product product = MockUpDataUtil.apple2;
        double orignalPrice = product.getFavourableStrategy().getOrginalPrice(product, 10);
        assertEquals(55d, orignalPrice, 0);

    }

    @Test
    public void testGetDeviation() throws Exception {
        Product product = MockUpDataUtil.apple2;
        double deviation = product.getFavourableStrategy().getDeviation(product, 10);
        assertEquals(0, deviation, 0);
    }
}
