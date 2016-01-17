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
    private long multiplier;

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

    public long getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(long multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public String toString() {
        return description;
    }
}
