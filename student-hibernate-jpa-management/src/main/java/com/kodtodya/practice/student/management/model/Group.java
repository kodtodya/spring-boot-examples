package com.kodtodya.practice.student.management.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Group {
    private int id;
    private String name;
    private Set<Student> students = new HashSet<>();
}
