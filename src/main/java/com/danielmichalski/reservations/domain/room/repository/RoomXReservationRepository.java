package com.danielmichalski.reservations.domain.room.repository;

import com.danielmichalski.reservations.domain.room.entity.RoomXReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomXReservationRepository extends JpaRepository<RoomXReservationEntity, Long> {

}
