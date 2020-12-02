package com.danielmichalski.reservations.business.dto.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ClientReservationCountDto {

    private final String name;
    private final String email;
    private final long count;

}
