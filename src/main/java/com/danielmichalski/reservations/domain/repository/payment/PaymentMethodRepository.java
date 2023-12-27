package com.danielmichalski.reservations.domain.repository.payment;

import com.danielmichalski.reservations.domain.entity.payment.PaymentMethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethodEntity, Long> {

    @Query("""
            SELECT pm.name AS name, COUNT(p.id) AS count
            FROM PaymentEntity p
            JOIN p.paymentMethod pm
            GROUP BY pm.name
            """
    )
    Object[][] getPaymentMethodCount();

}
