package com.itransition.santa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "not_santa")
    private Boolean notSanta;

    @Column(name = "not_child")
    private Boolean notChild;

    public Employee(String fullName) {
        this.fullName = fullName;
        notSanta = true;
        notChild = true;
    }

    @Override
    public String toString() {
        return fullName;
    }
}
