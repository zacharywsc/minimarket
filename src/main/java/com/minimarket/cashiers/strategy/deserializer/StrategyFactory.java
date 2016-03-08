package com.minimarket.cashiers.strategy.deserializer;

import com.fasterxml.jackson.databind.JsonNode;
import com.minimarket.cashiers.strategy.DefaultStrategy;
import com.minimarket.cashiers.strategy.DiscountStrategy;
import com.minimarket.cashiers.strategy.FavorableStrategy;
import com.minimarket.cashiers.strategy.FreeStrategy;

/**
 * Created by sw84437 on 3/3/2016.
 */
public class StrategyFactory {
    public static FavorableStrategy createFavorableStrategy(JsonNode node){
        String name = node.get("name").asText();

       if(DiscountStrategy.name.equals(name)){
            return constractDiscountStrategy(node);
        }
        else if(FreeStrategy.name.equals(name)){
            return constractFreeStrategy(node);
        }
        else{
            return constractDefaultStrategy();
        }

    }

    private static FavorableStrategy constractDiscountStrategy(JsonNode node) {
        double discount = node.get("discount").asDouble();
        return new DiscountStrategy(discount);

    }

    private static FavorableStrategy constractFreeStrategy(JsonNode node) {
        int conditionAmount = node.get("conditionAmount").asInt();
        int freeAmount = node.get("freeAmount").asInt();
        return new FreeStrategy(conditionAmount,freeAmount);
    }

    private static FavorableStrategy constractDefaultStrategy() {
        return DefaultStrategy.getDefaultStrategy();
    }
}
