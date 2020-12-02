package com.danielmichalski.reservations.business.app.service.room;

import java.util.List;

import com.danielmichalski.reservations.business.domain.entity.room.RoomEntity;
import com.danielmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import com.danielmichalski.reservations.business.util.annotation.TransactionalWrite;

public interface RoomService {

    @TransactionalReadOnly
    List<RoomEntity> findAll();

    @TransactionalWrite
    void remove(RoomEntity room);

    @TransactionalWrite
    void save(RoomEntity room);
}
