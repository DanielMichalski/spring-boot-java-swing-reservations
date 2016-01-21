package pl.dmichalski.reservations.business.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue
    @Column(name = "id_reservation")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_resrevation_status")
    private ReservationStatus reservationStatus;

    @ManyToOne
    @JoinColumn(name = "id_payment")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @Column(name = "from_date")
    private Date dateFrom;

    @Column(name = "to_date")
    private Date dateTo;

    @Column(name = "reservation_date")
    private Date reservationDate;

    @Column(name = "amount")
    private long amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return client.toString();
    }
}
