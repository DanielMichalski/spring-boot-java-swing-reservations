package pl.dmichalski.reservations.business.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class RoomXReservationPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_room")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "id_reservation")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomXReservationPK that = (RoomXReservationPK) o;

        if (room != null ? !room.equals(that.room) : that.room != null) return false;
        return reservation != null ? reservation.equals(that.reservation) : that.reservation == null;

    }

    @Override
    public int hashCode() {
        int result = room != null ? room.hashCode() : 0;
        result = 31 * result + (reservation != null ? reservation.hashCode() : 0);
        return result;
    }

}
