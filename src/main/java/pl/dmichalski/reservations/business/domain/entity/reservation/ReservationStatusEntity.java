package pl.dmichalski.reservations.business.domain.entity.reservation;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.dmichalski.reservations.business.domain.entity.BaseEntity;

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
