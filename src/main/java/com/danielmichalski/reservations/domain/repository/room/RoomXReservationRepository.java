package com.danielmichalski.reservations.domain.repository.room;

import com.danielmichalski.reservations.domain.entity.room.RoomXReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomXReservationRepository extends JpaRepository<RoomXReservationEntity, Long> {

}
