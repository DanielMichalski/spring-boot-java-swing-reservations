package pl.dmichalski.reservations.business.service.room;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dmichalski.reservations.business.domain.entity.room.RoomStatusEntity;
import pl.dmichalski.reservations.business.domain.repository.room.RoomStatusRepository;
import pl.dmichalski.reservations.business.dto.room.RoomStatusesCountDto;

@Service
@AllArgsConstructor
class RoomStatusServiceImpl implements RoomStatusService {

    private final RoomStatusRepository roomStatusRepository;

    public List<RoomStatusEntity> findAll() {
        return roomStatusRepository.findAll();
    }

    public void remove(RoomStatusEntity roomStatus) {
        roomStatusRepository.delete(roomStatus);
    }

    public void save(RoomStatusEntity roomStatus) {
        roomStatusRepository.save(roomStatus);
    }

    public List<RoomStatusesCountDto> getRoomStatusesCount() {
        Object[][] roomStatusesCount = roomStatusRepository.getRoomStatusesCount();
        return Stream.of(roomStatusesCount).map(rsc -> new RoomStatusesCountDto((String) rsc[0], (long) rsc[1])).collect(Collectors.toList());
    }

}
