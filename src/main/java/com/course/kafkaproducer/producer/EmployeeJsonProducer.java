package com.course.kafkaproducer.producer;

import com.course.kafkaproducer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeJsonProducer
{
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void produce(Employee employee)
    {
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(employee);
        }
        catch(JsonProcessingException e) {
            e.printStackTrace();
        }

        kafkaTemplate.send("t_employee", json);
        log.info("Writing to t_employee, json: {}", json);
    }
}
