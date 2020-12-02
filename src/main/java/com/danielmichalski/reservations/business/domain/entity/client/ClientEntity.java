package com.danielmichalski.reservations.business.domain.entity.client;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.danielmichalski.reservations.business.domain.entity.BaseEntity;
import com.danielmichalski.reservations.business.domain.entity.address.AddressEntity;

@Entity
@Table(name = "client")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ClientEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;

    private String name;

    private String surname;

    private String pesel;

    private String phoneNumber;

    private String email;

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
