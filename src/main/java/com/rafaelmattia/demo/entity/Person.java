package com.rafaelmattia.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@ToString
@Setter
@Getter
@Entity(name = "Person")
@Table(
        name = "person"
)
public class Person {

    @Id
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "person_sequence"
    )
    @Column(
            name = "idPerson",
            updatable = false
    )
    private Long idPerson;

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
    private LocalDate birthDate;

//    @OneToOne
//    @JoinColumn(name = "id")
//    private String principalAddress;

    public Person(String firstName,
                  String lastName,
                  LocalDate birthDate) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Person(){

    }
}