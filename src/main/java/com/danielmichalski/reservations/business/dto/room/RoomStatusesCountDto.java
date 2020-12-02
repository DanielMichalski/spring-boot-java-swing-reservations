package com.danielmichalski.reservations.business.dto.room;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RoomStatusesCountDto {

    private final String status;
    private final long count;

}
