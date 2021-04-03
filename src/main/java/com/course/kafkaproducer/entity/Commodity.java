package com.course.kafkaproducer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class Commodity
{
    private String name;

    private BigDecimal price;

    private String measurement;

    private long epochTimestamp;
}
