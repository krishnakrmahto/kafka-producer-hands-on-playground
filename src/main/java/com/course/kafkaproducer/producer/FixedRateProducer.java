package com.course.kafkaproducer.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;

//@Service
@RequiredArgsConstructor
@Slf4j
public class FixedRateProducer
{
    private final KafkaTemplate<String, String> kafkaTemplate;

    private int i = 0;

    @Scheduled(fixedRate = 1000)
    public void produce()
    {
        log.info("Value of i being sent: {}", i);
        kafkaTemplate.send("t_fixedrate_2", "Message no. " + i++);
    }
}
