package com.management.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeRequestDto {
    private double amount;
    private String description;
    private String categoty;
    private LocalDate date;
    private int userId;
}
