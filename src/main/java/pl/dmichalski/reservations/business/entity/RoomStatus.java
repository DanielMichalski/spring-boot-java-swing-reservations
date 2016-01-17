package pl.dmichalski.reservations.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "pokojstatus")
public class RoomStatus {

    @Id
    @GeneratedValue
    @Column(name = "idpokojstatus")
    private long id;

    @Column(name = "opis")
    private String description;

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
}
