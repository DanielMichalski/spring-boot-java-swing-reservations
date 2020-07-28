package pl.dmichalski.reservations.business.domain.entity.room;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dmichalski.reservations.business.domain.entity.reservation.ReservationEntity;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class RoomXReservationPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_room")
    private RoomEntity room;

    @ManyToOne
    @JoinColumn(name = "id_reservation")
    private ReservationEntity reservation;

}
