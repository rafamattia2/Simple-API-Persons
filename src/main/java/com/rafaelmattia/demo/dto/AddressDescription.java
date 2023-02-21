package com.rafaelmattia.demo.dto;

public record AddressDescription(
        Long id,
        String road,
        String cep,
        String city,
        Integer houseNumber
) {
}
