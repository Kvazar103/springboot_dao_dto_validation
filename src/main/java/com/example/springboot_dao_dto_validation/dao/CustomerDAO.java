package com.example.springboot_dao_dto_validation.dao;
import com.example.springboot_dao_dto_validation.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerDAO extends JpaRepository<Customer,Integer> {
    @Query("select c from Customer c where c.name=:name")
    List<Customer> getByName(@Param("name") String name);  // метод для пошуку по імені
    List<Customer> findCustomerById(int id); // spring data jpa query methods()
    /// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

}
//dao - data access object (конфігурація обєкту яка буде працювати з базами даних)
// JpaRepository<Customer,Integer> працює з обєктом Customer і в якості айді виступає Integer
