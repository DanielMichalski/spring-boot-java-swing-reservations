package com.danielmichalski.reservations.business.domain.entity.room;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.danielmichalski.reservations.business.domain.entity.BaseEntity;

@Entity
@Table(name = "room_type")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RoomTypeEntity extends BaseEntity {

    private String description;

    private Integer multiplier;

    @Override
    public String toString() {
        return description;
    }

}
