package com.course.kafkaproducer;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@AllArgsConstructor
public class KafkaProducerApplication
{
	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}
}
