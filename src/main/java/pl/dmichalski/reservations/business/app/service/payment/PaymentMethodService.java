package pl.dmichalski.reservations.business.app.service.payment;

import java.util.List;

import pl.dmichalski.reservations.business.domain.entity.payment.PaymentMethodEntity;
import pl.dmichalski.reservations.business.dto.payment.PaymentMethodCountDto;
import pl.dmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import pl.dmichalski.reservations.business.util.annotation.TransactionalWrite;

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
