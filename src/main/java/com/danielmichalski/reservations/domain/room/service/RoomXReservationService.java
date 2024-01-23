package com.danielmichalski.reservations.domain.room.service;

import com.danielmichalski.reservations.domain.room.entity.RoomXReservationEntity;
import com.danielmichalski.reservations.util.annotation.TransactionalReadOnly;
import com.danielmichalski.reservations.util.annotation.TransactionalWrite;

import java.util.List;

public interface RoomXReservationService {

    @TransactionalReadOnly
    List<RoomXReservationEntity> findAll();

    @TransactionalWrite
    void remove(RoomXReservationEntity roomXReservation);

    @TransactionalWrite
    void save(RoomXReservationEntity roomXReservation);

}
