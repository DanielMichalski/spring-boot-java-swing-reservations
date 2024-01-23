package com.danielmichalski.reservations.domain.room.repository;

import com.danielmichalski.reservations.domain.room.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

}
