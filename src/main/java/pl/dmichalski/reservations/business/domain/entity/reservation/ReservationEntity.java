package pl.dmichalski.reservations.business.domain.entity.reservation;

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
import pl.dmichalski.reservations.business.domain.entity.client.ClientEntity;
import pl.dmichalski.reservations.business.domain.entity.payment.PaymentEntity;

@Entity
@Table(name = "reservation")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ReservationEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "reservation_status_id")
    private ReservationStatusEntity reservationStatus;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private PaymentEntity payment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    private Date fromDate;

    private Date toDate;

    private Date reservationDate;

    private Long amount;

    @Override
    public String toString() {
        return client.toString();
    }

}
