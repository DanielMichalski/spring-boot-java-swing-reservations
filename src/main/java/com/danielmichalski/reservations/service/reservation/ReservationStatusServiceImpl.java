package com.danielmichalski.reservations.service.reservation;

import com.danielmichalski.reservations.domain.entity.reservation.ReservationStatusEntity;
import com.danielmichalski.reservations.domain.repository.reservation.ReservationStatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class ReservationStatusServiceImpl implements ReservationStatusService {

    private final ReservationStatusRepository reservationStatusRepository;

    @Override
    public List<ReservationStatusEntity> findAll() {
        return reservationStatusRepository.findAll();
    }

    @Override
    public void remove(ReservationStatusEntity reservationStatus) {
        reservationStatusRepository.delete(reservationStatus);
    }

    @Override
    public void save(ReservationStatusEntity reservationStatus) {
        reservationStatusRepository.save(reservationStatus);
    }
}
