package com.minimarket.cashiers.provider;

import com.minimarket.cashiers.Exception.ProductNotFindException;
import com.minimarket.cashiers.Product;

/**
 * Created by Zachary on 2016/3/2.
 */
public interface DBProvider {
    Product getProduct(String key) throws ProductNotFindException;
}
