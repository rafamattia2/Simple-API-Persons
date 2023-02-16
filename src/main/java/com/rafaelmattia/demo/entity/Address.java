package com.rafaelmattia.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "address_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "road",
            updatable = false,
            columnDefinition = "TEXT"
    )
    private String road;

    @Column(
            name = "cep",
            updatable = false,
            columnDefinition = "TEXT"
    )
    private String cep;

    @Column(
            name = "number",
            updatable = false,
            columnDefinition = "TEXT"
    )
    private Integer number;

    @Column(
            name = "city",
            updatable = false,
            columnDefinition = "TEXT"
    )
    private String city;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)

    private List<Person> personAddresses;

}