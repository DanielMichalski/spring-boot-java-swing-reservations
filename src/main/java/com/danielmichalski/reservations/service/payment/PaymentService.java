package com.danielmichalski.reservations.service.payment;

import com.danielmichalski.reservations.domain.entity.payment.PaymentEntity;
import com.danielmichalski.reservations.util.annotation.TransactionalReadOnly;
import com.danielmichalski.reservations.util.annotation.TransactionalWrite;

import java.util.List;

public interface PaymentService {

    @TransactionalReadOnly
    List<PaymentEntity> findAll();

    @TransactionalWrite
    void remove(PaymentEntity payment);

    @TransactionalWrite
    void save(PaymentEntity payment);
}
