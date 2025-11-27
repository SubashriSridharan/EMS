package com.management.ems.service;

import com.management.ems.dto.ResponseDto;
import com.management.ems.dto.IncomeRequestDto;
import com.management.ems.entity.Income;
import com.management.ems.exception.UserException;
import com.management.ems.repository.IncomeRepository;
import com.management.ems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class IncomeServiceImpl implements IncomeService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    IncomeRepository incomeRepository;

    @Override
    public ResponseEntity<ResponseDto> addIncome(IncomeRequestDto incomeRequestDto) {

        Income income= Income.builder().amount(incomeRequestDto.getAmount())
                .categoty(incomeRequestDto.getCategoty())
                .date(incomeRequestDto.getDate())
                .description(incomeRequestDto.getDescription())
                .user_income(
                        userRepository.findById(incomeRequestDto.getUserId())
                        .orElseThrow(()-> new UserException("User Not Found"))).build();
        incomeRepository.save(income);
        ResponseDto responseDto = ResponseDto.builder().message("Added Income Successfully")
                .statusCode(HttpStatus.OK.value()).build();
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }

}
