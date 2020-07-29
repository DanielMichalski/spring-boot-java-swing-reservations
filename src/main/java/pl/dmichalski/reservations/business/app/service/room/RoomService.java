package pl.dmichalski.reservations.business.app.service.room;

import java.util.List;

import pl.dmichalski.reservations.business.domain.entity.room.RoomEntity;
import pl.dmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import pl.dmichalski.reservations.business.util.annotation.TransactionalWrite;

public interface RoomService {

    @TransactionalReadOnly
    List<RoomEntity> findAll();

    @TransactionalWrite
    void remove(RoomEntity room);

    @TransactionalWrite
    void save(RoomEntity room);
}
