package com.danielmichalski.reservations.service.payment;

import com.danielmichalski.reservations.domain.entity.payment.PaymentMethodEntity;
import com.danielmichalski.reservations.domain.repository.payment.PaymentMethodRepository;
import com.danielmichalski.reservations.dto.payment.PaymentMethodCountDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
class PaymentMethodServiceImpl implements PaymentMethodService {

    public static final int NAME_INDEX = 0;
    public static final int COUNT_INDEX = 1;

    private final PaymentMethodRepository paymentMethodRepository;

    @Override
    public List<PaymentMethodEntity> findAll() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public void remove(PaymentMethodEntity paymentMethod) {
        paymentMethodRepository.delete(paymentMethod);
    }

    @Override
    public void save(PaymentMethodEntity paymentMethod) {
        paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public List<PaymentMethodCountDto> getPaymentMethodCount() {
        Object[][] paymentMethodCount = paymentMethodRepository.getPaymentMethodCount();
        return Stream.of(paymentMethodCount)
                .map(this::convertToPaymentMethodCountDto)
                .collect(Collectors.toList());
    }

    private PaymentMethodCountDto convertToPaymentMethodCountDto(Object... pmc) {
        String name = (String) pmc[NAME_INDEX];
        long count = (long) pmc[COUNT_INDEX];
        return new PaymentMethodCountDto(name, count);
    }
}
