package com.danielmichalski.reservations.service.payment;

import com.danielmichalski.reservations.domain.entity.payment.PaymentEntity;
import com.danielmichalski.reservations.domain.repository.payment.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public List<PaymentEntity> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public void remove(PaymentEntity payment) {
        paymentRepository.delete(payment);
    }

    @Override
    public void save(PaymentEntity payment) {
        paymentRepository.save(payment);
    }
}
