package pl.dmichalski.reservations.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue
    @Column(name = "id_room")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_room_status")
    private RoomStatus roomStatus;

    @Column(name = "number_of_people")
    private long numberOfPeople;

    @Column(name = "description")
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public long getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(long numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}