package pl.dmichalski.reservations.business.domain.entity.rate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.dmichalski.reservations.business.domain.entity.BaseEntity;
import pl.dmichalski.reservations.business.domain.entity.room.RoomEntity;
import pl.dmichalski.reservations.business.domain.entity.room.RoomTypeEntity;

@Entity
@Table(name = "rate")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RateEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_room")
    private RoomEntity room;

    @ManyToOne
    @JoinColumn(name = "id_room_type")
    private RoomTypeEntity roomType;

    private Long defaultRate;

}
