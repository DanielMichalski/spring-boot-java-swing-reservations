package pl.dmichalski.reservations.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmichalski.reservations.business.entity.PaymentMethod;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}