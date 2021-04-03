package com.course.kafkaproducer;

import com.course.kafkaproducer.entity.Employee;
import com.course.kafkaproducer.producer.EmployeeJsonProducer;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
//@EnableScheduling
@AllArgsConstructor
public class KafkaProducerApplication implements CommandLineRunner
{
	private final EmployeeJsonProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		for (int i = 0; i < 3; i++) {
			producer.produce(new Employee("emp-" + i, "Employee " + i, LocalDate.now()));
		}
	}
}
