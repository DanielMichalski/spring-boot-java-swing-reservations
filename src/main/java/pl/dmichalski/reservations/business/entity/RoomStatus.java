package pl.dmichalski.reservations.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "room_status")
public class RoomStatus {

    @Id
    @GeneratedValue
    @Column(name = "id_room_status")
    private long id;

    @Column(name = "room_status")
    private String roomStatus;

    @Column(name = "status_description")
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return roomStatus + " " + description;
    }
}
