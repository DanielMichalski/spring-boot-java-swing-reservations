package com.danielmichalski.reservations.business.app.service.reservation;

import java.util.List;

import com.danielmichalski.reservations.business.domain.entity.reservation.ReservationEntity;
import com.danielmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import com.danielmichalski.reservations.business.util.annotation.TransactionalWrite;

public interface ReservationService {

    @TransactionalReadOnly
    List<ReservationEntity> findAll();

    @TransactionalWrite
    void remove(ReservationEntity reservation);

    @TransactionalWrite
    void save(ReservationEntity reservation);

}
