package com.danielmichalski.reservations.business.app.service.payment;

import java.util.List;

import com.danielmichalski.reservations.business.domain.entity.payment.PaymentEntity;
import com.danielmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import com.danielmichalski.reservations.business.util.annotation.TransactionalWrite;

public interface PaymentService {

    @TransactionalReadOnly
    List<PaymentEntity> findAll();

    @TransactionalWrite
    void remove(PaymentEntity payment);

    @TransactionalWrite
    void save(PaymentEntity payment);
}
