package pl.dmichalski.reservations.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmichalski.reservations.business.entity.RoomType;
import pl.dmichalski.reservations.business.repository.RoomTypeRepository;

import java.util.List;

@Service
public class RoomTypeService {

    private RoomTypeRepository roomTypeRepository;

    @Autowired
    public RoomTypeService(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }

    public List<RoomType> findAll() {
        return roomTypeRepository.findAll();
    }

    public void remove(RoomType roomType) {
        roomTypeRepository.delete(roomType);
    }

    public void save(RoomType roomType) {
        roomTypeRepository.save(roomType);
    }

}
