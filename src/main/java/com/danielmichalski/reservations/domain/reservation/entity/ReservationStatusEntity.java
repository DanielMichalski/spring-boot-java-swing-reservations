package com.danielmichalski.reservations.domain.reservation.entity;

import com.danielmichalski.reservations.commons.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservation_status")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ReservationStatusEntity extends BaseEntity {

    private String status;

    @Override
    public String toString() {
        return status;
    }

}
