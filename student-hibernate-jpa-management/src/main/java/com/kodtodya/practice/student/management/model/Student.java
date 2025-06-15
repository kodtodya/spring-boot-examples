package com.kodtodya.practice.student.management.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    int id;
    String name;
    double percentage;
}