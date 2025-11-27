package com.management.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @GeneratedValue
    @Id
    private int id;
    private String name;
    private String username;
    private String password;
    @OneToMany(mappedBy = "user_income")
    private List<Income> income;
    @OneToMany(mappedBy = "user_expense")
    private List<Expense> expense;
}
