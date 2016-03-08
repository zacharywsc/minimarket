package com.minimarket.cashiers.strategy.serializer;

import com.fasterxml.jackson.databind.JsonNode;
import com.minimarket.cashiers.strategy.DefaultStrategy;
import com.minimarket.cashiers.strategy.DiscountStrategy;
import com.minimarket.cashiers.strategy.FavorableStrategy;
import com.minimarket.cashiers.strategy.FreeStrategy;

/**
 * Created by Zachary on 2016/3/4.
 */
public class FavorableStrategyFactory {
    public static FavorableStrategy createFavorableStrategy(JsonNode node) {
        String name = node.get("name").asText();

        if (DefaultStrategy.name.equals(name)) {
            return constructDiscountStrategy(node);
        } else if (name.startsWith(FreeStrategy.name)) {
            return contructFreeStrategy(node);
        } else {
            return contructDefaultStrategy();
        }
    }

    private static FavorableStrategy contructDefaultStrategy() {
        return DefaultStrategy.getDefaultStrategy();
    }

    private static FavorableStrategy contructFreeStrategy(JsonNode node) {
        int conditionAmount = node.get("conditionAmount").asInt();
        int freeAmount = node.get("freeAmount").asInt();
        return new FreeStrategy(conditionAmount,freeAmount);
    }

    private static FavorableStrategy constructDiscountStrategy(JsonNode node) {
        double discount = node.get("discount").asDouble();
        return new DiscountStrategy(discount);
    }
}
