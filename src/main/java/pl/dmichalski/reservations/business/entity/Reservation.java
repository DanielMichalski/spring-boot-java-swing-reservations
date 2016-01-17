package pl.dmichalski.reservations.business.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rezerwacja")
public class Reservation {

    @Id
    @GeneratedValue
    @Column(name = "idrezerwacja")
    private long id;

    @ManyToOne
    @JoinColumn(name = "idstatusrezerwacja")
    private ReservationStatus reservationStatus;

    @ManyToOne
    @JoinColumn(name = "idplatnosc")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "idklient")
    private Client client;

    @Column(name = "dataprzyjazd")
    private Date dateFrom;

    @Column(name = "datawyjazd")
    private Date dateTo;

    @Column(name = "datarezerwacja")
    private Date reservationDate;

    @Column(name = "suma")
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
}
