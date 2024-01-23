package com.danielmichalski.reservations.domain.room.entity;

import com.danielmichalski.reservations.commons.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "room")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RoomEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "room_status_id")
    private RoomStatusEntity roomStatus;

    @Column(name = "number_of_people")
    private Integer numberOfPeople;

    @Column(name = "description")
    private String description;

    @Override
    public String toString() {
        return description;
    }

}
