package com.danielmichalski.reservations.service.reservation;

import com.danielmichalski.reservations.domain.entity.reservation.ReservationEntity;
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
