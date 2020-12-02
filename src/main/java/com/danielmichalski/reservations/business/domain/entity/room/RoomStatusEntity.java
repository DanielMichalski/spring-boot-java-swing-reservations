package com.danielmichalski.reservations.business.domain.entity.room;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.danielmichalski.reservations.business.domain.entity.BaseEntity;

@Entity
@Table(name = "room_status")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RoomStatusEntity extends BaseEntity {

    private String status;

    private String statusDescription;

    @Override
    public String toString() {
        return status + " " + statusDescription;
    }

}
