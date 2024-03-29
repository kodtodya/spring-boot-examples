package com.kodtodya.practice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Customer {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
