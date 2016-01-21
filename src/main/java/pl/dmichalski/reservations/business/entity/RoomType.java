package pl.dmichalski.reservations.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "room_type")
public class RoomType {

    @Id
    @GeneratedValue
    @Column(name = "id_room_type")
    private long id;

    @Column(name = "description")
    private String description;

    @Column(name = "multiplier")
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
