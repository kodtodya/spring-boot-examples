package com.kodtodya.practice.batch.jobs.csvToDb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    String firstName;
    String lastName;
    int age;
    boolean active;
}
