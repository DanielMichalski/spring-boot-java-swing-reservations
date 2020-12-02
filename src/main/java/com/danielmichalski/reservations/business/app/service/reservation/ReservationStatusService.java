package com.danielmichalski.reservations.business.app.service.reservation;

import java.util.List;

import com.danielmichalski.reservations.business.domain.entity.reservation.ReservationStatusEntity;
import com.danielmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import com.danielmichalski.reservations.business.util.annotation.TransactionalWrite;

public interface ReservationStatusService {

    @TransactionalReadOnly
    List<ReservationStatusEntity> findAll();

    @TransactionalWrite
    void remove(ReservationStatusEntity reservationStatus);

    @TransactionalWrite
    void save(ReservationStatusEntity reservationStatus);
}
