package com.example.springboot_dao_dto_validation.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorDTO {
    private int code;
    private String msg;
}
