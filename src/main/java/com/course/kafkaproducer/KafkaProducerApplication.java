package com.course.kafkaproducer;

import com.course.kafkaproducer.producer.InvoiceProducer;
import com.course.kafkaproducer.service.InvoiceService;
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
//	private final FoodOrderProducer foodOrderProducer;
//	private final SimpleNumberProducer simpleNumberProducer;
//	private final ImageService imageService;
//	private final ImageProducer imageProducer;

	private final InvoiceService invoiceService;
	private final InvoiceProducer invoiceProducer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		for (int i = 0; i < 10; i++){
			if (i >= 5)
			{
				invoiceProducer.produce(invoiceService.generateInvoice(new BigDecimal(-1 * (i + 5)), "USD"));
			}
			else
			{
				invoiceProducer.produce(invoiceService.generateInvoice(new BigDecimal(i+5), "USD"));
			}
		}
	}
}
