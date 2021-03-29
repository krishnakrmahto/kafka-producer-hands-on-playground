package com.course.kafkaproducer;

import com.course.kafkaproducer.producer.KafkaKeyProducer;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableScheduling
@AllArgsConstructor
public class KafkaProducerApplication implements CommandLineRunner
{
	private final KafkaKeyProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception
	{
		for (int i = 0; i < 30; i++) {
			String key = "key-" + (i%4);
			String message = "message "  + i + " with key " + key;

			producer.produce(key, message);
		}
	}
}
