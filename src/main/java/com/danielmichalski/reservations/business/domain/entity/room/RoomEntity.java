package com.danielmichalski.reservations.business.domain.entity.room;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.danielmichalski.reservations.business.domain.entity.BaseEntity;

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
