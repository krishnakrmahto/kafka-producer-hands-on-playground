package com.course.kafkaproducer.service;

import com.course.kafkaproducer.entity.Commodity;
import com.course.kafkaproducer.producer.CommodityProducer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

//@Service
@AllArgsConstructor
@Slf4j
public class ScheduledCommodityPoller
{
    private final CommodityProducer producer;
    private final CommodityService service;

    private static int i = 0;

    @Scheduled(fixedRate = 5000)
    public void poll()
    {
        String commodityName = i++ % 2 == 0? "gold": "silver";
        List<Commodity> commodities = service.createDummyCommodities(1, commodityName);
        log.info("Commodities polled: {}", commodities);

        commodities.forEach(producer::produce);
    }
}
