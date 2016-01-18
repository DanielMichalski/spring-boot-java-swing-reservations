package pl.dmichalski.reservations.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmichalski.reservations.business.entity.RoomStatus;
import pl.dmichalski.reservations.business.entity.domain.RoomStatusesCount;
import pl.dmichalski.reservations.business.repository.RoomStatusRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RoomStatusService {

    private RoomStatusRepository roomStatusRepository;

    @Autowired
    public RoomStatusService(RoomStatusRepository roomStatusRepository) {
        this.roomStatusRepository = roomStatusRepository;
    }

    public List<RoomStatus> findAll() {
        return roomStatusRepository.findAll();
    }

    public void remove(RoomStatus roomStatus) {
        roomStatusRepository.delete(roomStatus);
    }

    public void save(RoomStatus roomStatus) {
        roomStatusRepository.save(roomStatus);
    }

    public List<RoomStatusesCount> getRoomStatusesCount() {
        Object[][] roomStatusesCount = roomStatusRepository.getRoomStatusesCount();
        return Stream.of(roomStatusesCount).map(rsc -> new RoomStatusesCount((String) rsc[0], (long) rsc[1])).collect(Collectors.toList());
    }

}
