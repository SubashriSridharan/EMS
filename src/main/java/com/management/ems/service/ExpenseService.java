package com.management.ems.service;

import com.management.ems.dto.ExpenseRequestDto;
import com.management.ems.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

public interface ExpenseService {
    public ResponseEntity<ResponseDto> addExpense(ExpenseRequestDto expenseRequestDto);
}
