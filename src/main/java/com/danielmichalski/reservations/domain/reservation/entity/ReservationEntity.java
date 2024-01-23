package com.danielmichalski.reservations.domain.reservation.entity;

import com.danielmichalski.reservations.commons.entity.BaseEntity;
import com.danielmichalski.reservations.domain.client.entity.ClientEntity;
import com.danielmichalski.reservations.domain.payment.entity.PaymentEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

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
