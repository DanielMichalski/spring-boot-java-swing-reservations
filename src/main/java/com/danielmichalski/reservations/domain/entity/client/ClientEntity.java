package com.danielmichalski.reservations.domain.entity.client;

import com.danielmichalski.reservations.domain.entity.BaseEntity;
import com.danielmichalski.reservations.domain.entity.address.AddressEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
