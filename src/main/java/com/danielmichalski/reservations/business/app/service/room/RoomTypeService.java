package com.danielmichalski.reservations.business.app.service.room;

import java.util.List;

import com.danielmichalski.reservations.business.domain.entity.room.RoomTypeEntity;
import com.danielmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import com.danielmichalski.reservations.business.util.annotation.TransactionalWrite;

public interface RoomTypeService {

    @TransactionalReadOnly
    List<RoomTypeEntity> findAll();

    @TransactionalWrite
    void remove(RoomTypeEntity roomType);

    @TransactionalWrite
    void save(RoomTypeEntity roomType);

}
