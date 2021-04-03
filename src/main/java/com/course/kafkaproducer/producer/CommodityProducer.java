package com.course.kafkaproducer.producer;

import com.course.kafkaproducer.entity.Commodity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CommodityProducer
{
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void produce(Commodity commodity)
    {
        String message = null;
        try {
            message = new ObjectMapper().writeValueAsString(commodity);
            log.info("Commodity msg producing: {}", message);
        }
        catch(JsonProcessingException e) {
            e.printStackTrace();
        }
        kafkaTemplate.send("t_commodity", commodity.getName(), message);
    }
}
