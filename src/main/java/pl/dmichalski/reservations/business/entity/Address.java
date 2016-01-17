package pl.dmichalski.reservations.business.entity;

import javax.persistence.*;

@Entity
@Table(name = "Adres")
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "idadres")
    private long idAddress;

    @Column(name = "ulica")
    private String street;

    @Column(name = "nr_domu")
    private String houseNumber;

    @Column(name = "nr_mieszkania")
    private String flatNumber;

    @Column(name = "miasto")
    private String city;

    @Column(name = "kodPocztowy")
    private String postCode;

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(long idAddress) {
        this.idAddress = idAddress;
    }

    @Override
    public String toString() {
        return street + " " +
                houseNumber + "/" +
                flatNumber + " " +
                city + " " +
                postCode;
    }
}
