package pl.dmichalski.reservations.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "pokojtyp")
public class RoomType {

    @Id
    @GeneratedValue
    @Column(name = "idpokojtyp")
    private long id;

    @Column(name = "opis")
    private String description;

    @Column(name = "mnoznik")
    private double multiplayer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMultiplayer() {
        return multiplayer;
    }

    public void setMultiplayer(double multiplayer) {
        this.multiplayer = multiplayer;
    }
}
