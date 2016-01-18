package pl.dmichalski.reservations.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmichalski.reservations.business.entity.RoomXReservation;
import pl.dmichalski.reservations.business.repository.RoomXReservationRepository;

import java.util.List;

@Service
public class RoomXReservationService {

    private RoomXReservationRepository roomXReservationRepository;

    @Autowired
    public RoomXReservationService(RoomXReservationRepository roomXReservationRepository) {
        this.roomXReservationRepository = roomXReservationRepository;
    }

    public List<RoomXReservation> findAll() {
        return roomXReservationRepository.findAll();
    }

    public void remove(RoomXReservation roomXReservation) {
        roomXReservationRepository.delete(roomXReservation);
    }

    public void save(RoomXReservation roomXReservation) {
        roomXReservationRepository.save(roomXReservation);
    }
}
