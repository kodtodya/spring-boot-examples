package com.kodtodya.practice.student.management.domain;

import com.kodtodya.practice.student.management.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "STUDENT_GROUP")
public class GroupDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_GROUP_MAPPING",
    joinColumns = @JoinColumn(name = "GROUP_ID"),
    inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
    private Set<StudentDomain> students = new HashSet<>();
}
