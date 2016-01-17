package pl.dmichalski.reservations.business.entity;

import javax.persistence.*;
import java.io.Serializable;

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
    private Serializable numberOfPeople;

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

    public Serializable getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Serializable numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
}
