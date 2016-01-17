package pl.dmichalski.reservations.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "pokoj")
public class Room {

    @Id
    @GeneratedValue
    @Column(name = "idpokoj")
    private long id;

    @ManyToOne
    @JoinColumn(name = "idpokojstatus")
    private RoomStatus roomStatus;

    @Column(name = "liczbaosob")
    private long numberOfPeople;

    @Column(name = "opis")
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