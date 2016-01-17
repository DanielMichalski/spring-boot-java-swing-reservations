package pl.dmichalski.reservations.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmichalski.reservations.business.entity.Reservation;
import pl.dmichalski.reservations.business.repository.ReservationRepository;

import java.util.List;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public void remove(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

}
