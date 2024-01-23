package com.danielmichalski.reservations.domain.reservation.service;

import com.danielmichalski.reservations.domain.reservation.entity.ReservationStatusEntity;
import com.danielmichalski.reservations.domain.reservation.repository.ReservationStatusRepository;
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
