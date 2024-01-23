package com.danielmichalski.reservations.domain.room.entity;

import com.danielmichalski.reservations.domain.reservation.entity.ReservationEntity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "room_x_reservation")
public class RoomXReservationEntity {

    @EmbeddedId
    private RoomXReservationPK roomXReservationPK;

    private Integer roomPrice;

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

    public void setRoomPrice(Integer roomPrice) {
        this.roomPrice = roomPrice;
    }
}
