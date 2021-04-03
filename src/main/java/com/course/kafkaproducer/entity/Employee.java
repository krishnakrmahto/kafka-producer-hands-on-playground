package com.course.kafkaproducer.entity;

import com.course.kafkaproducer.json.CustomLocalDateJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Employee
{
    private String employeeId;

    private String employeeName;

    @JsonSerialize(using = CustomLocalDateJsonSerializer.class)
    private LocalDate birthDate;
}
