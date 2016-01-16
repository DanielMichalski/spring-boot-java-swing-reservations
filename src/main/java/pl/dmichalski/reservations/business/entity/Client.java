package pl.dmichalski.reservations.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "Klient")
public class Client {

    @Id
    @GeneratedValue
    @Column(name = "IDKlient")
    private long id;

    @Column(name = "Imie")
    private String name;

    @Column(name = "Nazwisko")
    private String surname;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
