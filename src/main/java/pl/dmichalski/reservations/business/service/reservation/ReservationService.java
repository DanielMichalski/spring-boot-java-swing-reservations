package pl.dmichalski.reservations.business.service.reservation;

import java.util.List;

import pl.dmichalski.reservations.business.domain.entity.reservation.ReservationEntity;
import pl.dmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import pl.dmichalski.reservations.business.util.annotation.TransactionalWrite;

public interface ReservationService {

    @TransactionalReadOnly
    List<ReservationEntity> findAll();

    @TransactionalWrite
    void remove(ReservationEntity reservation);

    @TransactionalWrite
    void save(ReservationEntity reservation);

}
