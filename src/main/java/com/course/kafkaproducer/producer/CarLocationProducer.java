package com.course.kafkaproducer.producer;

import com.course.kafkaproducer.entity.CarLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarLocationProducer
{
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void produce(CarLocation carLocation)
    {
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(carLocation);
        }
        catch(JsonProcessingException e) {
            e.printStackTrace();
        }
        kafkaTemplate.send("t_location_sample_for_filter", carLocation.getCarId(), json);
    }
}
