package pl.dmichalski.reservations.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.dmichalski.reservations.business.entity.PaymentMethod;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

    @Query(value = "SELECT pm.name AS name, COUNT(p.id) AS count FROM Payment p JOIN p.paymentMethod pm GROUP BY pm.name")
    Object[][] getPaymentMethodCount();

}