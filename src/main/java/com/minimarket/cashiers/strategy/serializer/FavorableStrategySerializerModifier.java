package com.minimarket.cashiers.strategy.serializer;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.minimarket.cashiers.strategy.FavorableStrategy;

/**
 * Created by Zachary on 2016/3/4.
 */
public class FavorableStrategySerializerModifier extends BeanSerializerModifier {
    @Override
    public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDescription,JsonSerializer<?> serializer){
        if(beanDescription.getBeanClass() == FavorableStrategy.class){
            return  new FavorableStrategySerializer((JsonSerializer<Object>) serializer);

        }
        return serializer;

    }
}
