package com.course.kafkaproducer;

import com.course.kafkaproducer.entity.FoodOrder;
import com.course.kafkaproducer.producer.FoodOrderProducer;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
//@EnableScheduling
@AllArgsConstructor
public class KafkaProducerApplication implements CommandLineRunner
{
	private final FoodOrderProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		producer.produce(new FoodOrder("chicken", new BigDecimal(3)));
		producer.produce(new FoodOrder("fish", new BigDecimal(10)));
		producer.produce(new FoodOrder("pizza", new BigDecimal(5)));

	}
}
