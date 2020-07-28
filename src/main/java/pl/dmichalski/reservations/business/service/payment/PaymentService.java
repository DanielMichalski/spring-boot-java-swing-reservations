package pl.dmichalski.reservations.business.service.payment;

import java.util.List;

import pl.dmichalski.reservations.business.domain.entity.payment.PaymentEntity;
import pl.dmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import pl.dmichalski.reservations.business.util.annotation.TransactionalWrite;

public interface PaymentService {

    @TransactionalReadOnly
    List<PaymentEntity> findAll();

    @TransactionalWrite
    void remove(PaymentEntity payment);

    @TransactionalWrite
    void save(PaymentEntity payment);
}
