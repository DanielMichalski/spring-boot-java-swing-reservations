package com.danielmichalski.reservations.domain.repository.reservation;

import com.danielmichalski.reservations.domain.entity.reservation.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

}
