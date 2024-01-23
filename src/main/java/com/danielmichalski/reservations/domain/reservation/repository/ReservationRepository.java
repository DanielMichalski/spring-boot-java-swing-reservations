package com.danielmichalski.reservations.domain.reservation.repository;

import com.danielmichalski.reservations.domain.reservation.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

}
