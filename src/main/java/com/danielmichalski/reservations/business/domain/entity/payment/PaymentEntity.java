package com.danielmichalski.reservations.business.domain.entity.payment;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import com.danielmichalski.reservations.business.domain.entity.BaseEntity;

@Entity
@Table(name = "payment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PaymentEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethodEntity paymentMethod;

    private Long value;

    private Date dateOfPayment;

    public PaymentEntity(PaymentMethodEntity paymentMethod,
                         Long value,
                         Date dateOfPayment) {
        this.paymentMethod = paymentMethod;
        this.value = value;
        this.dateOfPayment = new Date(dateOfPayment.getTime());
    }

    @Override
    public String toString() {
        return paymentMethod + Strings.EMPTY;
    }

    public Date getDateOfPayment() {
        return new Date(dateOfPayment.getTime());
    }
}
