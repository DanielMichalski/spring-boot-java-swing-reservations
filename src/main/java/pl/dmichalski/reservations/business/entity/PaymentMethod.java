package pl.dmichalski.reservations.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "platnoscmetoda")
public class PaymentMethod {

    @Id
    @GeneratedValue
    @Column(name = "idplatnoscmetoda")
    private long id;

    @Column(name = "nazwa")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
