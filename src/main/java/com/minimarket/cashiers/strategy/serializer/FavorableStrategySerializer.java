package com.minimarket.cashiers.strategy.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.minimarket.cashiers.strategy.FavorableStrategy;

import java.io.IOException;

/**
 * Created by Zachary on 2016/3/4.
 */
public class FavorableStrategySerializer extends JsonSerializer<FavorableStrategy> {

    private final JsonSerializer<Object> defaultSerializer;

    public FavorableStrategySerializer(JsonSerializer<Object> defaultSerializer) {
        this.defaultSerializer = defaultSerializer;
    }

    @Override
    public void serialize(FavorableStrategy favorableStrategy, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        defaultSerializer.serialize(favorableStrategy,jsonGenerator,serializerProvider);
        jsonGenerator.writeStringField("name",favorableStrategy.getName());
        jsonGenerator.writeEndObject();
    }
}
