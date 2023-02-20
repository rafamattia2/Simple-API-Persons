package com.rafaelmattia.demo.dto;

import java.time.LocalDate;

public record PersonDescription(
        String firstName,
        String lastName,
        LocalDate birthDate
) {
}
