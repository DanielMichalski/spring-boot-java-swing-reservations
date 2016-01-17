
package pl.dmichalski.reservations.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmichalski.reservations.business.entity.PaymentMethod;
import pl.dmichalski.reservations.business.repository.PaymentMethodRepository;

import java.util.List;

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
}
