package com.danielmichalski.reservations.business.domain.entity.payment;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.danielmichalski.reservations.business.domain.entity.BaseEntity;

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
