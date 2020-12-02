package com.danielmichalski.reservations.business.app.service.payment;

import java.util.List;

import com.danielmichalski.reservations.business.domain.entity.payment.PaymentMethodEntity;
import com.danielmichalski.reservations.business.dto.payment.PaymentMethodCountDto;
import com.danielmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import com.danielmichalski.reservations.business.util.annotation.TransactionalWrite;

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
