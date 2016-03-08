package com.minimarket.cashiers.provider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minimarket.cashiers.Exception.ProductNotFindException;
import com.minimarket.cashiers.Product;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * Created by Zachary on 2016/3/2.
 */
public class MockProductProvider implements ProductProvider {


    public static String persistence = "persistence.txt";
    private Map<String, Product> productMap = new TreeMap<String, Product>();

    public MockProductProvider() {

        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Product getProduct(String key) throws ProductNotFindException {
        Product product = productMap.get(key);
        if (product == null) {
            throw new ProductNotFindException();
        }
        return product;
    }

    private void init() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File src = new File(persistence);
        TypeReference<List<Product>> valueTypeRef = new TypeReference<List<Product>>() {
        };
        List<Product> products = mapper.readValue(src, valueTypeRef);
        for (Product product : products) {
            productMap.put(product.getId(), product);
        }
    }

}
