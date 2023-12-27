package com.danielmichalski.reservations.service.reservation;

import com.danielmichalski.reservations.domain.entity.reservation.ReservationStatusEntity;
import com.danielmichalski.reservations.util.annotation.TransactionalReadOnly;
import com.danielmichalski.reservations.util.annotation.TransactionalWrite;

import java.util.List;

public interface ReservationStatusService {

    @TransactionalReadOnly
    List<ReservationStatusEntity> findAll();

    @TransactionalWrite
    void remove(ReservationStatusEntity reservationStatus);

    @TransactionalWrite
    void save(ReservationStatusEntity reservationStatus);
}
