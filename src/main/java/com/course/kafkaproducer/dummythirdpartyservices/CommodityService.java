package com.course.kafkaproducer.dummythirdpartyservices;

import com.course.kafkaproducer.entity.Commodity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CommodityService
{
    public List<Commodity> createDummyCommodities(int numberOfCommodities, String name)
    {
        return IntStream.range(0, numberOfCommodities)
                        .mapToObj(i -> Commodity.builder()
                                                .name(name)
                                                .price(BigDecimal.TEN.add(new BigDecimal(i)))
                                                .epochTimestamp(System.currentTimeMillis())
                                                .build())
                        .collect(Collectors.toList());
    }
}
