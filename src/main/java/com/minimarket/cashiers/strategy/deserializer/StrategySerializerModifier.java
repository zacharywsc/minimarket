package com.minimarket.cashiers.strategy.deserializer;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.minimarket.cashiers.strategy.FavorableStrategy;

/**
 * Created by sw84437 on 3/3/2016.
 */
public class StrategySerializerModifier extends BeanSerializerModifier {
    @Override
    public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {
        if (beanDesc.getBeanClass() == FavorableStrategy.class) {
            return new StrategySerializer((JsonSerializer<Object>) serializer);
        }
        return serializer;
    }
}
