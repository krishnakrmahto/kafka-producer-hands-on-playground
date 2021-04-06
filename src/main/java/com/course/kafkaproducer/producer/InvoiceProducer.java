package com.course.kafkaproducer.producer;

import com.course.kafkaproducer.entity.Invoice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class InvoiceProducer
{
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void produce(Invoice invoice)
    {
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(invoice);
        }
        catch(JsonProcessingException e) {
            e.printStackTrace();
        }

        log.info("Producing invoice: {}", invoice);
        kafkaTemplate.send("t_invoice", invoice.getId(), json);
    }
}
