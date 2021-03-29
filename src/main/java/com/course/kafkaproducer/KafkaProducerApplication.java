package com.course.kafkaproducer;

import com.course.kafkaproducer.producer.HelloKafkaProducer;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class KafkaProducerApplication implements CommandLineRunner
{
	private final HelloKafkaProducer kafkaProducer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		kafkaProducer.produce("Hello, sample kafka producer msg - 1");
	}
}
