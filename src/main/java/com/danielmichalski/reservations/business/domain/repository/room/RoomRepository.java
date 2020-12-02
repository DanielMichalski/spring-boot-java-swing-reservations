package com.danielmichalski.reservations.business.domain.repository.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.danielmichalski.reservations.business.domain.entity.room.RoomEntity;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
}
