package com.kodtodya.practice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "Customer")
@ToString
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Customer {

    @Id
    @ToString.Exclude
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    private String lastName;

    @ToString.Exclude
    private String email;

    @ToString.Exclude
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdTime;

    @Column(nullable = false)
    @CreatedDate
    @LastModifiedDate
    private LocalDateTime updatedTime;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
