package pl.dmichalski.reservations.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "pokojstatus")
public class RoomStatus {

    @Id
    @GeneratedValue
    @Column(name = "idpokojstatus")
    private long id;

    @Column(name = "statuspokoju")
    private String roomStatus;

    @Column(name = "opisstatusu")
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
