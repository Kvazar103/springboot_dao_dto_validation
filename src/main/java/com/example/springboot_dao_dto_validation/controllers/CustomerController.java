package com.example.springboot_dao_dto_validation.controllers;


import com.example.springboot_dao_dto_validation.dao.CustomerDAO;
import com.example.springboot_dao_dto_validation.models.Customer;
import com.example.springboot_dao_dto_validation.models.Views.Views;
import com.example.springboot_dao_dto_validation.services.CustomerService;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    private CustomerDAO customerDAO;
    private CustomerService customerService;


    @JsonView(Views.User.class)  //для юзера буде показувати тільки нейм (репрезентація проходить через Юзер)
    @GetMapping("")
    public ResponseEntity<List<Customer>> getCustomers(){
        return new ResponseEntity<>(customerDAO.findAll(), HttpStatus.OK);
    }
    @PostMapping("")
    public void saveCustomer(@RequestBody Customer customer){
//        customerDAO.save(customer);
        customerService.save(customer);  //using CustomerService instead customerDAO
    }
     @JsonView(Views.Admin.class)  // для адміна всі поля буде показувати
    @GetMapping("/{id}")   ///"/customers/{id}"
    public ResponseEntity<Customer> getCustomer(@PathVariable int id){
        return new ResponseEntity<>(customerDAO.findById(id).get(),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id){
        customerDAO.deleteById(id);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id,@RequestBody Customer customer){
        Customer obj=customerDAO.findById(id).get();
        obj.setName(customer.getName());
        customerDAO.save(obj);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @GetMapping("/name/{name}")    ///  "/customers/name/petro"
    public ResponseEntity<List<Customer>> getCustomerByName(@PathVariable String name){
        return new ResponseEntity<>(customerDAO.getByName(name),HttpStatus.OK);
//        return new ResponseEntity<>(customerDAO.findCustomerById(2),HttpStatus.OK);  //solution spring data jpa query find by id 2
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<Customer> updateCustomerDTO(@PathVariable int id,@RequestBody CustomerDTO customerr){
//        Customer obj=customerDAO.findById(id).get();
//        obj.setName(customerr.getSurname());
//        customerDAO.save(obj);
//        return new ResponseEntity<>(obj,HttpStatus.OK);
//    }
// for DTO
}
