package com.rafaelmattia.demo.dto;

import lombok.Setter;

import java.util.Set;

public record AddressForm(
        Long id,
        String road,
        String cep,
        Integer houseNumber,
        String city
//        Set<Long> personsId

) {
}
