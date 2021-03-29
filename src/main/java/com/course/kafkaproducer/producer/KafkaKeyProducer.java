package com.course.kafkaproducer.producer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class KafkaKeyProducer
{
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void produce(String key, String message)
    {
        log.info("key: {}, message: {}", key, message);
        kafkaTemplate.send("t_multiple_partitions", key, message);
    }
}
