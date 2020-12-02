package com.danielmichalski.reservations.business.domain.repository.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.danielmichalski.reservations.business.domain.entity.reservation.ReservationStatusEntity;

@Repository
public interface ReservationStatusRepository extends JpaRepository<ReservationStatusEntity, Long> {
}
