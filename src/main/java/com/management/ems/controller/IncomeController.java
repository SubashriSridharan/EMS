package com.management.ems.controller;

import com.management.ems.dto.ResponseDto;
import com.management.ems.dto.IncomeRequestDto;
import com.management.ems.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/income")
public class IncomeController {

    @Autowired
    IncomeService incomeService;

    @PostMapping("/")
    public ResponseEntity<ResponseDto> addIncome(@RequestBody IncomeRequestDto incomeRequestDto){
        return incomeService.addIncome(incomeRequestDto);
    }
}
