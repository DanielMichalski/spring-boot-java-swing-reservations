package com.danielmichalski.reservations.domain.entity.rate;

import com.danielmichalski.reservations.domain.entity.BaseEntity;
import com.danielmichalski.reservations.domain.entity.room.RoomEntity;
import com.danielmichalski.reservations.domain.entity.room.RoomTypeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rate")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RateEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity room;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomTypeEntity roomType;

    private Long defaultRate;

}
