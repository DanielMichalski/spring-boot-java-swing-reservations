package pl.dmichalski.reservations.business.service.reservation;

import java.util.List;

import pl.dmichalski.reservations.business.domain.entity.reservation.ReservationStatusEntity;
import pl.dmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import pl.dmichalski.reservations.business.util.annotation.TransactionalWrite;

public interface ReservationStatusService {

    @TransactionalReadOnly
    List<ReservationStatusEntity> findAll();

    @TransactionalWrite
    void remove(ReservationStatusEntity reservationStatus);

    @TransactionalWrite
    void save(ReservationStatusEntity reservationStatus);
}
