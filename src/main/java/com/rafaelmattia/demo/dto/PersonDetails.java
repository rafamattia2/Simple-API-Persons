package com.rafaelmattia.demo.dto;

import java.time.LocalDate;
import java.util.Set;

public record PersonDetails(
        Long id,
        String firstName,
        String lastName,
        LocalDate birthDate,
        AddressDetails principalAddressDetails,
        Set<AddressDescription> addresses
){
}
