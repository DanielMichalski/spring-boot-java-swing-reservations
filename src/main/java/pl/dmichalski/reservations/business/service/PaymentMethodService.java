
package pl.dmichalski.reservations.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmichalski.reservations.business.entity.PaymentMethod;
import pl.dmichalski.reservations.business.entity.domain.PaymentMethodCount;
import pl.dmichalski.reservations.business.repository.PaymentMethodRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PaymentMethodService {

    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public List<PaymentMethod> findAll() {
        return paymentMethodRepository.findAll();
    }

    public void remove(PaymentMethod paymentMethod) {
        paymentMethodRepository.delete(paymentMethod);
    }

    public void save(PaymentMethod paymentMethod) {
        paymentMethodRepository.save(paymentMethod);
    }

    public List<PaymentMethodCount> getPaymentMethodCount() {
        Object[][] paymentMethodCount = paymentMethodRepository.getPaymentMethodCount();
        return Stream.of(paymentMethodCount).map(pmc -> new PaymentMethodCount((String) pmc[0], (long) pmc[1])).collect(Collectors.toList());
    }
}
