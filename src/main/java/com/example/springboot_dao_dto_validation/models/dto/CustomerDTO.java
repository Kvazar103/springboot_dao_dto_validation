package com.example.springboot_dao_dto_validation.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// dto- data transfer object
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String surname;
}
