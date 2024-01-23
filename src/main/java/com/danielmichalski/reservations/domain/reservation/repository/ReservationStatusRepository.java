package com.danielmichalski.reservations.domain.reservation.repository;

import com.danielmichalski.reservations.domain.reservation.entity.ReservationStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationStatusRepository extends JpaRepository<ReservationStatusEntity, Long> {

}
