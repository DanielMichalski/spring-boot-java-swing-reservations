package com.danielmichalski.reservations.business.app.service.room;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.danielmichalski.reservations.business.domain.entity.room.RoomEntity;
import com.danielmichalski.reservations.business.domain.repository.room.RoomRepository;

@Service
@AllArgsConstructor
class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public List<RoomEntity> findAll() {
        return roomRepository.findAll();
    }

    public void remove(RoomEntity room) {
        roomRepository.delete(room);
    }

    public void save(RoomEntity room) {
        roomRepository.save(room);
    }
}
