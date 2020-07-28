package pl.dmichalski.reservations.business.domain.entity.room;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import pl.dmichalski.reservations.business.domain.entity.reservation.ReservationEntity;

@Entity
@Table(name = "room_x_reservation")
public class RoomXReservationEntity {

    @EmbeddedId
    private RoomXReservationPK roomXReservationPK;

    private long roomPrice;

    public RoomXReservationEntity() {
    }

    public RoomXReservationEntity(RoomXReservationPK roomXReservationPK) {
        this.roomXReservationPK = roomXReservationPK;
    }

    public RoomEntity getRoom() {
        return roomXReservationPK.getRoom();
    }

    public void setRoom(RoomEntity room) {
        roomXReservationPK.setRoom(room);
    }

    public ReservationEntity getReservation() {
        return roomXReservationPK.getReservation();
    }

    public void setReservation(ReservationEntity reservation) {
        roomXReservationPK.setReservation(reservation);
    }

    public long getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(long roomPrice) {
        this.roomPrice = roomPrice;
    }
}
