package com.danielmichalski.reservations.domain.room.repository;

import com.danielmichalski.reservations.domain.room.entity.RoomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomTypeEntity, Long> {

}
