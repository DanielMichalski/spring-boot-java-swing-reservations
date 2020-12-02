package com.danielmichalski.reservations.business.app.service.rate;

import java.util.List;

import com.danielmichalski.reservations.business.domain.entity.rate.RateEntity;
import com.danielmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import com.danielmichalski.reservations.business.util.annotation.TransactionalWrite;

public interface RateService {

    @TransactionalReadOnly
    List<RateEntity> findAll();

    @TransactionalWrite
    void remove(RateEntity rate);

    @TransactionalWrite
    void save(RateEntity rate);
}
