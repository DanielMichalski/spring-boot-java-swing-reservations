package com.danielmichalski.reservations.service.room;

import com.danielmichalski.reservations.domain.entity.room.RoomXReservationEntity;
import com.danielmichalski.reservations.domain.repository.room.RoomXReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class RoomXReservationServiceImpl implements RoomXReservationService {

    private final RoomXReservationRepository roomXReservationRepository;

    @Override
    public List<RoomXReservationEntity> findAll() {
        return roomXReservationRepository.findAll();
    }

    @Override
    public void remove(RoomXReservationEntity roomXReservation) {
        roomXReservationRepository.delete(roomXReservation);
    }

    @Override
    public void save(RoomXReservationEntity roomXReservation) {
        roomXReservationRepository.save(roomXReservation);
    }
}
