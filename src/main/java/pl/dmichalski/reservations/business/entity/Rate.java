package pl.dmichalski.reservations.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "rate")
public class Rate {

    @Id
    @GeneratedValue
    @Column(name = "id_rate")
    private long idstawka;

    @ManyToOne
    @JoinColumn(name = "id_room")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "id_room_type")
    private RoomType roomType;

    @Column(name = "default_rate")
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
