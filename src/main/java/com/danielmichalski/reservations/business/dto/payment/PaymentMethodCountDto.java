package com.danielmichalski.reservations.business.dto.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PaymentMethodCountDto {

    private final String name;
    private final long count;

}
