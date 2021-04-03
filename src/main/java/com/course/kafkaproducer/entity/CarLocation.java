package com.course.kafkaproducer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarLocation
{
    private String carId;

    private int distance;

    private long epochTimestamp;
}
