package pl.dmichalski.reservations.business.service.room;

import java.util.List;

import pl.dmichalski.reservations.business.domain.entity.room.RoomStatusEntity;
import pl.dmichalski.reservations.business.dto.room.RoomStatusesCountDto;
import pl.dmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import pl.dmichalski.reservations.business.util.annotation.TransactionalWrite;

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
