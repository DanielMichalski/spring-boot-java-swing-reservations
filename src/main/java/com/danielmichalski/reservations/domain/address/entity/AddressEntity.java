package com.danielmichalski.reservations.domain.address.entity;

import com.danielmichalski.reservations.commons.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AddressEntity extends BaseEntity {

    private String street;

    private String houseNumber;

    private String flatNumber;

    private String city;

    private String postalCode;

    @Override
    public String toString() {
        return street + " "
                + houseNumber
                + "/" + flatNumber + " "
                + city + " "
                + postalCode;
    }
}
