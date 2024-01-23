package com.danielmichalski.reservations.domain.room.service;

import com.danielmichalski.reservations.domain.room.entity.RoomEntity;
import com.danielmichalski.reservations.util.annotation.TransactionalReadOnly;
import com.danielmichalski.reservations.util.annotation.TransactionalWrite;

import java.util.List;

public interface RoomService {

    @TransactionalReadOnly
    List<RoomEntity> findAll();

    @TransactionalWrite
    void remove(RoomEntity room);

    @TransactionalWrite
    void save(RoomEntity room);
}
