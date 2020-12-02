package com.danielmichalski.reservations.business.app.service.room;

import java.util.List;

import com.danielmichalski.reservations.business.domain.entity.room.RoomXReservationEntity;
import com.danielmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import com.danielmichalski.reservations.business.util.annotation.TransactionalWrite;

public interface RoomXReservationService {

    @TransactionalReadOnly
    List<RoomXReservationEntity> findAll();

    @TransactionalWrite
    void remove(RoomXReservationEntity roomXReservation);

    @TransactionalWrite
    void save(RoomXReservationEntity roomXReservation);

}
