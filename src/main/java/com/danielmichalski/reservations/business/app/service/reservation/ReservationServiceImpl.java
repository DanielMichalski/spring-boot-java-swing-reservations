package com.danielmichalski.reservations.business.app.service.reservation;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.danielmichalski.reservations.business.domain.entity.reservation.ReservationEntity;
import com.danielmichalski.reservations.business.domain.repository.reservation.ReservationRepository;

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
