package pl.dmichalski.reservations.business.app.service.payment;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dmichalski.reservations.business.domain.entity.payment.PaymentMethodEntity;
import pl.dmichalski.reservations.business.domain.repository.payment.PaymentMethodRepository;
import pl.dmichalski.reservations.business.dto.payment.PaymentMethodCountDto;

@Service
@AllArgsConstructor
class PaymentMethodServiceImpl implements PaymentMethodService {

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
                .map(pmc -> new PaymentMethodCountDto((String) pmc[0], (long) pmc[1]))
                .collect(Collectors.toList());
    }
}
