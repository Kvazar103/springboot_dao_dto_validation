package com.example.springboot_dao_dto_validation.services;

import com.example.springboot_dao_dto_validation.dao.CustomerDAO;
import com.example.springboot_dao_dto_validation.models.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerDAO customerDAO;

    public void save(Customer customer){
        if(customer.getId()>0){
            customerDAO.save(customer);
        }else {
            throw new RuntimeException("id <0");
        }
    }

}
