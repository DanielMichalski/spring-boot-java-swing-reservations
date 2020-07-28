package pl.dmichalski.reservations.business.service.room;

import java.util.List;

import pl.dmichalski.reservations.business.domain.entity.room.RoomTypeEntity;
import pl.dmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import pl.dmichalski.reservations.business.util.annotation.TransactionalWrite;

public interface RoomTypeService {

    @TransactionalReadOnly
    List<RoomTypeEntity> findAll();

    @TransactionalWrite
    void remove(RoomTypeEntity roomType);

    @TransactionalWrite
    void save(RoomTypeEntity roomType);

}
