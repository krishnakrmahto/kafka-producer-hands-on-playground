package com.course.kafkaproducer.producer;

import com.course.kafkaproducer.entity.SimpleNumber;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class SimpleNumberProducer
{
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void produce(SimpleNumber simpleNumber)
    {
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(simpleNumber);
        }
        catch(JsonProcessingException e) {
            e.printStackTrace();
        }

        kafkaTemplate.send("t_simple_number", json);
        log.info("Message produced: {}", json);
    }
}
