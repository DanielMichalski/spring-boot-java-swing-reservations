package com.danielmichalski.reservations.business.app.service.room;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.danielmichalski.reservations.business.domain.entity.room.RoomXReservationEntity;
import com.danielmichalski.reservations.business.domain.repository.room.RoomXReservationRepository;

@Service
@AllArgsConstructor
class RoomXReservationServiceImpl implements RoomXReservationService {

    private final RoomXReservationRepository roomXReservationRepository;

    public List<RoomXReservationEntity> findAll() {
        return roomXReservationRepository.findAll();
    }

    public void remove(RoomXReservationEntity roomXReservation) {
        roomXReservationRepository.delete(roomXReservation);
    }

    public void save(RoomXReservationEntity roomXReservation) {
        roomXReservationRepository.save(roomXReservation);
    }
}
