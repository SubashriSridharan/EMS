package com.management.ems.controller;

import com.management.ems.dto.ExpenseRequestDto;
import com.management.ems.dto.IncomeRequestDto;
import com.management.ems.dto.ResponseDto;
import com.management.ems.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/expense")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @PostMapping("/")
    public ResponseEntity<ResponseDto> addExpense(@RequestBody ExpenseRequestDto expenseRequestDto){
        System.out.println("Expense Controller Data");
        return expenseService.addExpense(expenseRequestDto);
    }
}
