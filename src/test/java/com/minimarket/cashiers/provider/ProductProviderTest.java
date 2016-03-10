package com.minimarket.cashiers.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.minimarket.cashiers.MockUpDataUtil;
import com.minimarket.cashiers.Product;
import com.minimarket.cashiers.strategy.deserializer.StrategySerializerModifier;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Zachary on 2016/3/3.
 */
public class ProductProviderTest {

    private ProductProvider productProvider;


    @Before
    public void setup() throws IOException {

        writeProductToFile();
        productProvider = new MockProductProvider();

    }

    private void writeProductToFile() throws IOException {
        List<Product> productList = new LinkedList<Product>();
        productList.add(MockUpDataUtil.cola);
        productList.add(MockUpDataUtil.apple);
        productList.add(MockUpDataUtil.shuttlecocks);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new SimpleModule().setSerializerModifier(new StrategySerializerModifier()));
        mapper.writeValue(new File(MockProductProvider.persistence),productList);
    }

    @Test
    public void testGetProduct() throws Exception {
        Product product = productProvider.getProduct("ITEM000001");
        assertEquals(MockUpDataUtil.cola, product);
    }
}