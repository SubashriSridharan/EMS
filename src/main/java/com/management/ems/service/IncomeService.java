package com.management.ems.service;

import com.management.ems.dto.ResponseDto;
import com.management.ems.dto.IncomeRequestDto;
import org.springframework.http.ResponseEntity;


public interface IncomeService {

    public ResponseEntity<ResponseDto> addIncome(IncomeRequestDto incomeRequestDto);
}
