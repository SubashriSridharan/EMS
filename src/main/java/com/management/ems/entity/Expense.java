package com.management.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "expense")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    @GeneratedValue
    @Id
    private int expenseId;
    private double amount;
    private String description;
    private String categoty;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name ="user")
    private User user_expense;
}
