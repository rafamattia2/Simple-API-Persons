package com.rafaelmattia.demo.dto;

import com.rafaelmattia.demo.entity.Address;

import java.time.LocalDate;
import java.util.Set;

public record PersonDetails(
        String firstName,
        String lastName,
        LocalDate birthDate,
        Address principalAddress,
        Set<AddressDescription> addresses

){
}
