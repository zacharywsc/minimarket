package com.minimarket.cashiers.strategy.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.minimarket.cashiers.strategy.DiscountStrategy;
import com.minimarket.cashiers.strategy.FavorableStrategy;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.io.IOException;

/**
 * Created by sw84437 on 3/3/2016.
 */

public class StrategyDeserializer extends JsonDeserializer<FavorableStrategy> {
    @Override
    public FavorableStrategy deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        FavorableStrategy favorableStrategy = StrategyFactory.createFavorableStrategy(node);
        return favorableStrategy;
    }

}
