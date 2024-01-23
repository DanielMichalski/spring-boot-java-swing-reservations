package com.danielmichalski.reservations.domain.room.service;

import com.danielmichalski.reservations.domain.room.dto.RoomStatusesCountDto;
import com.danielmichalski.reservations.domain.room.entity.RoomStatusEntity;
import com.danielmichalski.reservations.util.annotation.TransactionalReadOnly;
import com.danielmichalski.reservations.util.annotation.TransactionalWrite;

import java.util.List;

public interface RoomStatusService {

    @TransactionalReadOnly
    List<RoomStatusEntity> findAll();

    @TransactionalWrite
    void remove(RoomStatusEntity roomStatus);

    @TransactionalWrite
    void save(RoomStatusEntity roomStatus);

    @TransactionalReadOnly
    List<RoomStatusesCountDto> getRoomStatusesCount();

}
