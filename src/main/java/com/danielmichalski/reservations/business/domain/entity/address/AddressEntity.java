package com.danielmichalski.reservations.business.domain.entity.address;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.danielmichalski.reservations.business.domain.entity.BaseEntity;

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
        return street + " " +
                houseNumber + "/" +
                flatNumber + " " +
                city + " " +
                postalCode;
    }
}
