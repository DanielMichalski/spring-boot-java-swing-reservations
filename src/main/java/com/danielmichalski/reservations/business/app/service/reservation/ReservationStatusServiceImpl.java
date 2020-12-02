package com.danielmichalski.reservations.business.app.service.reservation;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.danielmichalski.reservations.business.domain.entity.reservation.ReservationStatusEntity;
import com.danielmichalski.reservations.business.domain.repository.reservation.ReservationStatusRepository;

@Service
@AllArgsConstructor
class ReservationStatusServiceImpl implements ReservationStatusService {

    private final ReservationStatusRepository reservationStatusRepository;

    public List<ReservationStatusEntity> findAll() {
        return reservationStatusRepository.findAll();
    }

    public void remove(ReservationStatusEntity reservationStatus) {
        reservationStatusRepository.delete(reservationStatus);
    }

    public void save(ReservationStatusEntity reservationStatus) {
        reservationStatusRepository.save(reservationStatus);
    }
}
