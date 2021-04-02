package com.course.kafkaproducer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Employee
{
    private String employeeId;

    private String employeeName;

    private LocalDate birthDate;
}
