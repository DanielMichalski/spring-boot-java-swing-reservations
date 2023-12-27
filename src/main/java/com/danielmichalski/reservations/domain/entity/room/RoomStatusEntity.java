package com.danielmichalski.reservations.domain.entity.room;

import com.danielmichalski.reservations.domain.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
