package com.danielmichalski.reservations.domain.repository.room;

import com.danielmichalski.reservations.domain.entity.room.RoomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomTypeEntity, Long> {

}
