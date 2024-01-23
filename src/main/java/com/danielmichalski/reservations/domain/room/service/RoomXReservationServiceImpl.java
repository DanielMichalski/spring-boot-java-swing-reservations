package com.danielmichalski.reservations.domain.room.service;

import com.danielmichalski.reservations.domain.room.entity.RoomXReservationEntity;
import com.danielmichalski.reservations.domain.room.repository.RoomXReservationRepository;
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
