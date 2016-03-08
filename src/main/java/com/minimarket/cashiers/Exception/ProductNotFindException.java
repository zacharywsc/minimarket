package com.minimarket.cashiers.Exception;

/**
 * Created by Zachary on 2016/3/2.
 */
public class ProductNotFindException extends Exception {
    public ProductNotFindException(String productKey) {
        super("can't find product key: "+productKey);
    }

}
