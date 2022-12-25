package com.example.springboot_dao_dto_validation.controllers;

import com.example.springboot_dao_dto_validation.models.dto.ErrorDTO;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(ConstraintViolationException.class)  /// спрацьовує при цій помилці
    public ErrorDTO errorValidation(ConstraintViolationException e){
        return new ErrorDTO(500,e.getMessage());
    }
}
