package com.danielmichalski.reservations.domain.reservation.service;

import com.danielmichalski.reservations.domain.reservation.entity.ReservationEntity;
import com.danielmichalski.reservations.util.annotation.TransactionalReadOnly;
import com.danielmichalski.reservations.util.annotation.TransactionalWrite;

import java.util.List;

public interface ReservationService {

    @TransactionalReadOnly
    List<ReservationEntity> findAll();

    @TransactionalWrite
    void remove(ReservationEntity reservation);

    @TransactionalWrite
    void save(ReservationEntity reservation);

}
