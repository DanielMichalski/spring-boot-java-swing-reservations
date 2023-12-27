package com.danielmichalski.reservations.service.payment;

import com.danielmichalski.reservations.domain.entity.payment.PaymentMethodEntity;
import com.danielmichalski.reservations.dto.payment.PaymentMethodCountDto;
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
