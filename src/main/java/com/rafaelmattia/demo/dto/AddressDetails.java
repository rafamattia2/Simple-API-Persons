package com.rafaelmattia.demo.dto;

import java.util.Set;

public record AddressDetails(
        Long id,
        String road,
        String cep,
        String city,
        Integer houseNumber,
        Set<PersonDescription> persons
) {
}
