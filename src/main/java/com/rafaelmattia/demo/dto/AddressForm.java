package com.rafaelmattia.demo.dto;
public record AddressForm(
        Long id,
        String road,
        String cep,
        Integer houseNumber,
        String city
) {
}
