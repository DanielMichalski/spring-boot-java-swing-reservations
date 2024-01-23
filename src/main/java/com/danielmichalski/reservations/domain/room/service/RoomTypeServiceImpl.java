package com.danielmichalski.reservations.domain.room.service;

import com.danielmichalski.reservations.domain.room.entity.RoomTypeEntity;
import com.danielmichalski.reservations.domain.room.repository.RoomTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class RoomTypeServiceImpl implements RoomTypeService {

    private final RoomTypeRepository roomTypeRepository;

    @Override
    public List<RoomTypeEntity> findAll() {
        return roomTypeRepository.findAll();
    }

    @Override
    public void remove(RoomTypeEntity roomType) {
        roomTypeRepository.delete(roomType);
    }

    @Override
    public void save(RoomTypeEntity roomType) {
        roomTypeRepository.save(roomType);
    }

}
