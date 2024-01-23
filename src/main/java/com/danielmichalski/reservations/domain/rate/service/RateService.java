package com.danielmichalski.reservations.domain.rate.service;

import com.danielmichalski.reservations.domain.rate.entity.RateEntity;
import com.danielmichalski.reservations.util.annotation.TransactionalReadOnly;
import com.danielmichalski.reservations.util.annotation.TransactionalWrite;

import java.util.List;

public interface RateService {

    @TransactionalReadOnly
    List<RateEntity> findAll();

    @TransactionalWrite
    void remove(RateEntity rate);

    @TransactionalWrite
    void save(RateEntity rate);
}
