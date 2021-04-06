package com.course.kafkaproducer.producer;

import com.course.kafkaproducer.entity.Image;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageProducer
{
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void produce(Image image)
    {
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(image);
        }
        catch(JsonProcessingException e) {
            e.printStackTrace();
        }

        kafkaTemplate.send("t_images", image.getType(), json);
    }
}
