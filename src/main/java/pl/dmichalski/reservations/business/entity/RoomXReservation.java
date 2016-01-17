package pl.dmichalski.reservations.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "pokoj_x_rezerwacja")
public class RoomXReservation {

    @EmbeddedId
    private RoomXReservationPK roomXReservationPK;

    @Column(name = "cenapokoj")
    private long roomPrice;

    public RoomXReservation() {
    }

    public RoomXReservation(RoomXReservationPK roomXReservationPK) {
        this.roomXReservationPK = roomXReservationPK;
    }

    public Room getRoom() {
        return roomXReservationPK.getRoom();
    }

    public void setRoom(Room room) {
        roomXReservationPK.setRoom(room);
    }

    public Reservation getReservation() {
        return roomXReservationPK.getReservation();
    }

    public void setReservation(Reservation reservation) {
        roomXReservationPK.setReservation(reservation);
    }

    public long getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(long roomPrice) {
        this.roomPrice = roomPrice;
    }
}