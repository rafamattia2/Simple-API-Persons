package com.rafaelmattia.demo.entity;

import com.rafaelmattia.demo.repository.AddressRepository;
import com.rafaelmattia.demo.repository.PersonRepository;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PersonAddressDTO {
    private Person person;
    private Address address;
}
