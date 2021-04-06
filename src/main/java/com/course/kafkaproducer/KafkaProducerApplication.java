package com.course.kafkaproducer;

import com.course.kafkaproducer.producer.ImageProducer;
import com.course.kafkaproducer.service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableScheduling
@AllArgsConstructor
public class KafkaProducerApplication implements CommandLineRunner
{
//	private final FoodOrderProducer foodOrderProducer;
//	private final SimpleNumberProducer simpleNumberProducer;
	private final ImageService imageService;
	private final ImageProducer imageProducer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		imageProducer.produce(imageService.generateImage("jpg"));
		imageProducer.produce(imageService.generateImage("svg"));
		imageProducer.produce(imageService.generateImage("png"));
	}
}
