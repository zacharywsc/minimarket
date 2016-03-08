package com.minimarket.cashiers.strategy;

import com.minimarket.cashiers.MockUpDataUtil;
import com.minimarket.cashiers.Product;
import com.minimarket.cashiers.ShoppingList;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Zachary on 2016/3/3.
 */
public class FreeStrategyTest {

    @Test
    public void testGetFavorablePrice() throws Exception {
        Product product = MockUpDataUtil.cola;
        ShoppingList.ShoppingItem item = new ShoppingList.ShoppingItem(product,3);
        double favorablePrice = product.getFavourableStrategy().getFavorablePrice(item);
        int freeAmount = product.getFavourableStrategy().getUnCountingAmount(item);
        assertEquals(6,favorablePrice,0);
        assertEquals(1,freeAmount);
    }
}