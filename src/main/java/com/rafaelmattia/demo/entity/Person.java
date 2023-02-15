package com.rafaelmattia.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import static jakarta.persistence.GenerationType.AUTO;

@Entity(name = "Person")
@Table(
        name = "person"
)
@Setter
@Getter
public class Person {

    @Id
    @SequenceGenerator(
            name = "person_generator",
            sequenceName = "person_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = AUTO,
            generator = "person_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "birth_date"
    )
    private Date birthDate;

    public Person(Long id,
                  String firstName,
                  String lastName,
                  Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Person(){

    }
}