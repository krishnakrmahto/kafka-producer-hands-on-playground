package com.course.kafkaproducer.service;

import com.course.kafkaproducer.entity.Invoice;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class InvoiceService
{
    private static int counter = 0;

    public Invoice generateInvoice(BigDecimal amount, String currency)
    {
        String id = "INV-"  + counter++;
        return new Invoice(id, amount, currency);
    }
}
