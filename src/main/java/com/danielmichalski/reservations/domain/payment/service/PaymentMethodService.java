package com.danielmichalski.reservations.domain.payment.service;

import com.danielmichalski.reservations.domain.payment.dto.PaymentMethodCountDto;
import com.danielmichalski.reservations.domain.payment.entity.PaymentMethodEntity;
import com.danielmichalski.reservations.util.annotation.TransactionalReadOnly;
import com.danielmichalski.reservations.util.annotation.TransactionalWrite;

import java.util.List;

public interface PaymentMethodService {

    @TransactionalReadOnly
    List<PaymentMethodEntity> findAll();

    @TransactionalWrite
    void remove(PaymentMethodEntity paymentMethod);

    @TransactionalWrite
    void save(PaymentMethodEntity paymentMethod);

    @TransactionalReadOnly
    List<PaymentMethodCountDto> getPaymentMethodCount();
}
