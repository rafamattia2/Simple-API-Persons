package com.rafaelmattia.demo.dto;

import com.rafaelmattia.demo.entity.Address;

import java.time.LocalDate;
import java.util.Set;

public record PersonForm(
        String firstName,
        String lastName,
        LocalDate birthDate,
        Address principalAddress
//        Set<Long> addressesId


) {
}
