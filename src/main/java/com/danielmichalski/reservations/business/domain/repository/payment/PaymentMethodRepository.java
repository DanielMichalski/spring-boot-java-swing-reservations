package com.danielmichalski.reservations.business.domain.repository.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.danielmichalski.reservations.business.domain.entity.payment.PaymentMethodEntity;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethodEntity, Long> {

    @Query(value = "SELECT pm.name AS name, COUNT(p.id) AS count " +
            "FROM PaymentEntity p " +
            "JOIN p.paymentMethod pm " +
            "GROUP BY pm.name")
    Object[][] getPaymentMethodCount();

}
