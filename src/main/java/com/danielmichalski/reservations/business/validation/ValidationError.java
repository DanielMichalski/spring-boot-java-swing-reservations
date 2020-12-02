package com.danielmichalski.reservations.business.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ValidationError {

    private final String message;

}
