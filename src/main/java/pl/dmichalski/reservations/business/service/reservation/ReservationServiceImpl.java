package pl.dmichalski.reservations.business.service.reservation;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dmichalski.reservations.business.domain.entity.reservation.ReservationEntity;
import pl.dmichalski.reservations.business.domain.repository.reservation.ReservationRepository;

@Service
@AllArgsConstructor
class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    public List<ReservationEntity> findAll() {
        return reservationRepository.findAll();
    }

    public void remove(ReservationEntity reservation) {
        reservationRepository.delete(reservation);
    }

    public void save(ReservationEntity reservation) {
        reservationRepository.save(reservation);
    }

}
