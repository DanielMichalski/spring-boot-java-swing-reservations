package com.danielmichalski.reservations.business.app.service.payment;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.danielmichalski.reservations.business.domain.entity.payment.PaymentMethodEntity;
import com.danielmichalski.reservations.business.domain.repository.payment.PaymentMethodRepository;
import com.danielmichalski.reservations.business.dto.payment.PaymentMethodCountDto;

@Service
@AllArgsConstructor
class PaymentMethodServiceImpl implements PaymentMethodService {

    public static final int NAME_INDEX = 0;
    public static final int COUNT_INDEX = 1;

    private final PaymentMethodRepository paymentMethodRepository;

    public List<PaymentMethodEntity> findAll() {
        return paymentMethodRepository.findAll();
    }

    public void remove(PaymentMethodEntity paymentMethod) {
        paymentMethodRepository.delete(paymentMethod);
    }

    public void save(PaymentMethodEntity paymentMethod) {
        paymentMethodRepository.save(paymentMethod);
    }

    public List<PaymentMethodCountDto> getPaymentMethodCount() {
        Object[][] paymentMethodCount = paymentMethodRepository.getPaymentMethodCount();
        return Stream.of(paymentMethodCount)
                .map(this::convertToPaymentMethodCountDto)
                .collect(Collectors.toList());
    }

    private PaymentMethodCountDto convertToPaymentMethodCountDto(Object[] pmc) {
        String name = (String) pmc[NAME_INDEX];
        long count = (long) pmc[COUNT_INDEX];
        return new PaymentMethodCountDto(name, count);
    }
}
