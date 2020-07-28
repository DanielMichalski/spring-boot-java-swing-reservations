package pl.dmichalski.reservations.business.service.room;

import java.util.List;

import pl.dmichalski.reservations.business.domain.entity.room.RoomXReservationEntity;
import pl.dmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import pl.dmichalski.reservations.business.util.annotation.TransactionalWrite;

public interface RoomXReservationService {

    @TransactionalReadOnly
    List<RoomXReservationEntity> findAll();

    @TransactionalWrite
    void remove(RoomXReservationEntity roomXReservation);

    @TransactionalWrite
    void save(RoomXReservationEntity roomXReservation);

}
