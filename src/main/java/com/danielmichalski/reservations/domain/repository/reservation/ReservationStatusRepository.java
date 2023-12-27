package com.danielmichalski.reservations.domain.repository.reservation;

import com.danielmichalski.reservations.domain.entity.reservation.ReservationStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationStatusRepository extends JpaRepository<ReservationStatusEntity, Long> {

}
