package pl.dmichalski.reservations.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "status_rezerwacji")
public class ReservationStatus {

    @Id
    @GeneratedValue
    @Column(name = "idstatusrezerwacja")
    private long id;

    @Column(name = "status_rezerwacji")
    private String reservationStatus;

    public long getId() {
        return id;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    @Override
    public String toString() {
        return reservationStatus;
    }
}
