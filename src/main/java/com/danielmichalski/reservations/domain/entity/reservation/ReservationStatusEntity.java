package com.danielmichalski.reservations.domain.entity.reservation;

import com.danielmichalski.reservations.domain.entity.BaseEntity;
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
