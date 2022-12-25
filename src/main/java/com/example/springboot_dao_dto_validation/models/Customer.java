package com.example.springboot_dao_dto_validation.models;


import com.example.springboot_dao_dto_validation.models.Views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Admin.class)  //адмінам показує
    private int id;
    @NotEmpty
    @Length(min = 2,max = 25,message = "The field must be at least 2 characters")
    @JsonView({Views.Admin.class,Views.User.class}) //адмінам показує і юзерам
    private String name;
}
