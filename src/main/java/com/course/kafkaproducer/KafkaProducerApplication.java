package com.course.kafkaproducer;

import com.course.kafkaproducer.entity.FoodOrder;
import com.course.kafkaproducer.entity.SimpleNumber;
import com.course.kafkaproducer.producer.FoodOrderProducer;
import com.course.kafkaproducer.producer.SimpleNumberProducer;
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
	private final FoodOrderProducer foodOrderProducer;
	private final SimpleNumberProducer simpleNumberProducer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		foodOrderProducer.produce(new FoodOrder("chicken", new BigDecimal(3)));
		foodOrderProducer.produce(new FoodOrder("fish", new BigDecimal(10)));
		foodOrderProducer.produce(new FoodOrder("pizza", new BigDecimal(5)));

		for (int i = 0; i < 100; i++)
		{
			simpleNumberProducer.produce(new SimpleNumber(i));
		}
	}
}
