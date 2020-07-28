package pl.dmichalski.reservations.business.domain.repository.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmichalski.reservations.business.domain.entity.reservation.ReservationStatusEntity;

@Repository
public interface ReservationStatusRepository extends JpaRepository<ReservationStatusEntity, Long> {
}
