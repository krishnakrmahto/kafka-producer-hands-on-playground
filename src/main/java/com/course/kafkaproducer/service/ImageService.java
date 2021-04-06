package com.course.kafkaproducer.service;

import com.course.kafkaproducer.entity.Image;
import com.course.kafkaproducer.producer.ImageProducer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
@Slf4j
@AllArgsConstructor
public class ImageService
{
    private final ImageProducer producer;

    private static int counter = 0;

    public Image generateImage(String type)
    {
        String imageName = "image-" + counter;
        long size = ThreadLocalRandom.current().nextLong(100, 10000);

        return new Image(imageName, size, type);
    }
}
