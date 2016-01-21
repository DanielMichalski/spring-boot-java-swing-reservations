package pl.dmichalski.reservations.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "payment_method")
public class PaymentMethod {

    @Id
    @GeneratedValue
    @Column(name = "id_payment_method")
    private long id;

    @Column(name = "name")
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
