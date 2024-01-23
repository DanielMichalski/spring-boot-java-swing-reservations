package com.danielmichalski.reservations.domain.reservation.service;

import com.danielmichalski.reservations.domain.reservation.entity.ReservationEntity;
import com.danielmichalski.reservations.domain.reservation.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public List<ReservationEntity> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public void remove(ReservationEntity reservation) {
        reservationRepository.delete(reservation);
    }

    @Override
    public void save(ReservationEntity reservation) {
        reservationRepository.save(reservation);
    }

}
