package com.course.kafkaproducer.service;

import com.course.kafkaproducer.entity.CarLocation;
import com.course.kafkaproducer.producer.CarLocationProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

//@Service
@Slf4j
@RequiredArgsConstructor
public class CarLocationService
{
    private CarLocation carOneLocation = new CarLocation("car-1", 0, System.currentTimeMillis());
    private CarLocation carTwoLocation = new CarLocation("car-2", 110, System.currentTimeMillis());;
    private CarLocation carThreeLocation = new CarLocation("car-3", 95, System.currentTimeMillis());;

    private final CarLocationProducer producer;

    @Scheduled(fixedRate = 10000)
    public void generateCarLocation()
    {
        long currentEpochTimestamp = System.currentTimeMillis();

        carOneLocation.setDistance(carOneLocation.getDistance() + 1);
        carTwoLocation.setDistance(carTwoLocation.getDistance() - 1);
        carThreeLocation.setDistance(carThreeLocation.getDistance() + 1);

        carOneLocation.setEpochTimestamp(currentEpochTimestamp);
        carTwoLocation.setEpochTimestamp(currentEpochTimestamp);
        carThreeLocation.setEpochTimestamp(currentEpochTimestamp);

        producer.produce(carOneLocation);
        log.info("sent carOneLocation: {}", carOneLocation);
        producer.produce(carTwoLocation);
        log.info("sent carTwoLocation: {}", carTwoLocation);
        producer.produce(carThreeLocation);
        log.info("sent carThreeLocation: {}", carThreeLocation);
    }
}
