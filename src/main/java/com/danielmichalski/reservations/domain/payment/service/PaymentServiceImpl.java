package com.danielmichalski.reservations.domain.payment.service;

import com.danielmichalski.reservations.domain.payment.entity.PaymentEntity;
import com.danielmichalski.reservations.domain.payment.repository.PaymentRepository;
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
