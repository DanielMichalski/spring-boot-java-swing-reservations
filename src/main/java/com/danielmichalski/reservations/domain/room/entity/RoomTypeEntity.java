package com.danielmichalski.reservations.domain.room.entity;

import com.danielmichalski.reservations.commons.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
