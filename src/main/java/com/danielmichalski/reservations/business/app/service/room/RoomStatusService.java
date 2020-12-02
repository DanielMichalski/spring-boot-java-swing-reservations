package com.danielmichalski.reservations.business.app.service.room;

import java.util.List;

import com.danielmichalski.reservations.business.domain.entity.room.RoomStatusEntity;
import com.danielmichalski.reservations.business.dto.room.RoomStatusesCountDto;
import com.danielmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import com.danielmichalski.reservations.business.util.annotation.TransactionalWrite;

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
