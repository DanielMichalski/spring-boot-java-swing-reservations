package pl.dmichalski.reservations.business.domain.entity.payment;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.dmichalski.reservations.business.domain.entity.BaseEntity;

@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PaymentEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_payment_method")
    private PaymentMethodEntity paymentMethod;

    private Long value;

    private Date dateOfPayments;

}
