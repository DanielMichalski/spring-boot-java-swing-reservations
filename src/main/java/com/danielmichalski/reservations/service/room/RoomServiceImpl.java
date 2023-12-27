package com.danielmichalski.reservations.service.room;

import com.danielmichalski.reservations.domain.entity.room.RoomEntity;
import com.danielmichalski.reservations.domain.repository.room.RoomRepository;
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
