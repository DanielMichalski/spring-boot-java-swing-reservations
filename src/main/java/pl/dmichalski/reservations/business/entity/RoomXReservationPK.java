package pl.dmichalski.reservations.business.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class RoomXReservationPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idpokoj")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "idrezerwacja")
    private Reservation reservation;

    public RoomXReservationPK() {
    }

    public RoomXReservationPK(Room room, Reservation reservation) {
        this.room = room;
        this.reservation = reservation;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
