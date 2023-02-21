package com.rafaelmattia.demo.dto;

import java.time.LocalDate;

public record PersonDescription(
        Long id,
        String firstName,
        String lastName,
        LocalDate birthDate
) {
}
