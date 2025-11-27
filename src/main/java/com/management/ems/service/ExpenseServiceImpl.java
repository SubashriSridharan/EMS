package com.management.ems.service;

import com.management.ems.dto.ExpenseRequestDto;
import com.management.ems.dto.ResponseDto;
import com.management.ems.entity.Expense;
import com.management.ems.entity.Income;
import com.management.ems.exception.UserException;
import com.management.ems.repository.ExpenseRepository;
import com.management.ems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements ExpenseService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    ExpenseRepository expenseRepository;
    @Override
    public ResponseEntity<ResponseDto> addExpense(ExpenseRequestDto expenseRequestDto) {
        Expense income= Expense.builder().amount(expenseRequestDto.getAmount())
                .categoty(expenseRequestDto.getCategoty())
                .date(expenseRequestDto.getDate())
                .description(expenseRequestDto.getDescription())
                .user_expense(
                        userRepository.findById(expenseRequestDto.getUserId())
                                .orElseThrow(()-> new UserException("User Not Found"))).build();
        expenseRepository.save(income);
        ResponseDto responseDto = ResponseDto.builder().message("Added Expense Successfully")
                .statusCode(HttpStatus.OK.value()).build();
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }
}
