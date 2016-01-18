package pl.dmichalski.reservations.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "stawka")
public class Rate {

    @Id
    @GeneratedValue
    @Column(name = "idstawka")
    private long idstawka;

    @ManyToOne
    @JoinColumn(name = "idpokoj")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "idpokojtyp")
    private RoomType roomType;

    @Column(name = "stawkapodstawowa")
    private long basicRate;

    public long getIdstawka() {
        return idstawka;
    }

    public void setIdstawka(long idstawka) {
        this.idstawka = idstawka;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public long getBasicRate() {
        return basicRate;
    }

    public void setBasicRate(long basicRate) {
        this.basicRate = basicRate;
    }

}
