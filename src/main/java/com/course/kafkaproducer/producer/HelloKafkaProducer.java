package com.course.kafkaproducer.producer;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class HelloKafkaProducer
{
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void produce(String message)
    {
        kafkaTemplate.send("t_hello", message);
    }
}
