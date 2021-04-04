package com.course.kafkaproducer.producer;

import com.course.kafkaproducer.entity.FoodOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class FoodOrderProducer
{
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void produce(FoodOrder foodOrder)
    {
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(foodOrder);
        }
        catch(JsonProcessingException e) {
            e.printStackTrace();
        }

        log.info("Sending json: {}", json);
        kafkaTemplate.send("t_food_order", json);
    }
}
