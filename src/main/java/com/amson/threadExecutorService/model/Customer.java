package com.amson.threadExecutorService.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    private Long customer_id;

    @Size(min = 6, max = 255, message = "Customer Full Name MUST be of length between  3 and 255 characters")
    private String fullName;

    @Size(min = 8, max = 14, message = "Mobile number length should be between 8 - 14.")
    private String mobile_number;

    @Email(message = "Email should be valid!")
    private String email;

}
