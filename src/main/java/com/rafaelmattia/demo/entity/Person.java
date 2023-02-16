package com.rafaelmattia.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "birth_date"
    )
    private LocalDate birthDate;

    @OneToOne
    @JoinColumn(
            //name = "address_id",
            referencedColumnName = "id",
            unique = true
            //nullable = false
    )
    private Address principalAddress;

//    @ManyToMany
//    private Set<Address> addresses;

}