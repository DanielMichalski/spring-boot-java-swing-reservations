package com.danielmichalski.reservations.domain.entity.payment;

import com.danielmichalski.reservations.domain.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payment_method")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PaymentMethodEntity extends BaseEntity {

    private String name;

    @Override
    public String toString() {
        return name;
    }

}
