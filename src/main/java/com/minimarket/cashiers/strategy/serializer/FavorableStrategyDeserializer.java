package com.minimarket.cashiers.strategy.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.minimarket.cashiers.strategy.FavorableStrategy;

import java.io.IOException;

/**
 * Created by Zachary on 2016/3/4.
 */
public class FavorableStrategyDeserializer extends JsonDeserializer<FavorableStrategy> {
    @Override
    public FavorableStrategy deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        FavorableStrategy favorableStrategy = FavorableStrategyFactory.createFavorableStrategy(node);
        return favorableStrategy;
    }
}
