package pl.dmichalski.reservations.business.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Klient")
public class Client {

    @Id
    @GeneratedValue
    @Column(name = "idklient")
    private long clientId;

    @Column(name = "idadres")
    private long idaddress;

    @Column(name = "imie")
    private String name;

    @Column(name = "nazwisko")
    private String surname;

    @Column(name = "pesel")
    private String pesel;

    @Column(name = "telefon")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    public Serializable getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public Serializable getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(long idaddress) {
        this.idaddress = idaddress;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
