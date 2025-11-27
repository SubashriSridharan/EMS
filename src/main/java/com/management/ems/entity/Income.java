package com.management.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "income")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Income {

    @GeneratedValue
    @Id
    private int incomeId;
    private double amount;
    private String description;
    private String categoty;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user_income;
}
