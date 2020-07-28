package pl.dmichalski.reservations.business.domain.entity.room;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.dmichalski.reservations.business.domain.entity.BaseEntity;

@Entity
@Table(name = "room_status")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RoomStatusEntity extends BaseEntity {

    private String roomStatus;

    private String statusDescription;

}
