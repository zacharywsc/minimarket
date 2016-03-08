package com.minimarket.cashiers.provider;

import com.minimarket.cashiers.Exception.ProductNotFindException;
import com.minimarket.cashiers.Product;

import java.io.IOException;

/**
 * Created by Zachary on 2016/3/2.
 */
public interface ProductProvider {
    Product getProduct(String key) throws ProductNotFindException;

}
