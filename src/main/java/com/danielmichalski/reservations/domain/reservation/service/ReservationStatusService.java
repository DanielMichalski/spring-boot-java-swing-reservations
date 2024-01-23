package com.danielmichalski.reservations.domain.reservation.service;

import com.danielmichalski.reservations.domain.reservation.entity.ReservationStatusEntity;
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
