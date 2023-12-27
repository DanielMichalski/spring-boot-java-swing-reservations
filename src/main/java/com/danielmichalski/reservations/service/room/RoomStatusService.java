package com.danielmichalski.reservations.service.room;

import com.danielmichalski.reservations.domain.entity.room.RoomStatusEntity;
import com.danielmichalski.reservations.dto.room.RoomStatusesCountDto;
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
