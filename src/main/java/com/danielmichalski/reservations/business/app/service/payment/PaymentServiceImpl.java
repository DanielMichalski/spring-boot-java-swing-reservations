package com.danielmichalski.reservations.business.app.service.payment;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.danielmichalski.reservations.business.domain.entity.payment.PaymentEntity;
import com.danielmichalski.reservations.business.domain.repository.payment.PaymentRepository;

@Service
@AllArgsConstructor
class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public List<PaymentEntity> findAll() {
        return paymentRepository.findAll();
    }

    public void remove(PaymentEntity payment) {
        paymentRepository.delete(payment);
    }

    public void save(PaymentEntity payment) {
        paymentRepository.save(payment);
    }
}
