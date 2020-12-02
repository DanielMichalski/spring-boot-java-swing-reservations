package com.danielmichalski.reservations.business.domain.entity.reservation;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.danielmichalski.reservations.business.domain.entity.BaseEntity;
import com.danielmichalski.reservations.business.domain.entity.client.ClientEntity;
import com.danielmichalski.reservations.business.domain.entity.payment.PaymentEntity;

@Entity
@Table(name = "reservation")
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

    public ReservationEntity(ReservationStatusEntity reservationStatus,
                             PaymentEntity payment,
                             ClientEntity client,
                             Date fromDate,
                             Date toDate,
                             Date reservationDate,
                             Long amount) {
        this.reservationStatus = reservationStatus;
        this.payment = payment;
        this.client = client;
        this.fromDate = new Date(fromDate.getTime());
        this.toDate = new Date(toDate.getTime());
        this.reservationDate = new Date(reservationDate.getTime());
        this.amount = amount;
    }

    @Override
    public String toString() {
        return client.toString();
    }

    public Date getFromDate() {
        return new Date(fromDate.getTime());
    }

    public Date getToDate() {
        return new Date(toDate.getTime());
    }

    public Date getReservationDate() {
        return new Date(reservationDate.getTime());
    }
}
