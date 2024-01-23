package com.danielmichalski.reservations.domain.room.service;

import com.danielmichalski.reservations.domain.room.entity.RoomEntity;
import com.danielmichalski.reservations.domain.room.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public List<RoomEntity> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public void remove(RoomEntity room) {
        roomRepository.delete(room);
    }

    @Override
    public void save(RoomEntity room) {
        roomRepository.save(room);
    }
}
