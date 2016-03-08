package com.minimarket.cashiers.strategy.deserializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.minimarket.cashiers.strategy.FavorableStrategy;

import java.io.IOException;

/**
 * Created by sw84437 on 3/3/2016.
 */
public class StrategySerializer  extends JsonSerializer<FavorableStrategy> {

    private final JsonSerializer<Object> defaultSerializer;

    public StrategySerializer(JsonSerializer<Object> defaultSerializer) {
        this.defaultSerializer = defaultSerializer;
    }

    @Override
    public void serialize(FavorableStrategy favorableStrategy, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        defaultSerializer.serialize(favorableStrategy, jsonGenerator, serializerProvider);
        jsonGenerator.writeStringField("name", favorableStrategy.getName());
        jsonGenerator.writeEndObject();

    }
}
