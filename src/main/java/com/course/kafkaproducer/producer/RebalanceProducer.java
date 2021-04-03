package com.course.kafkaproducer.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;

//@Service
@Slf4j
@RequiredArgsConstructor
public class RebalanceProducer
{
    private final KafkaTemplate<String, String> kafkaTemplate;

    private int i = 0;

    @Scheduled(fixedRate = 2000)
    public void produce()
    {
        kafkaTemplate.send("t_rebalance_test", "i = " + i++);
    }
}
