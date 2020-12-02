package com.danielmichalski.reservations.business.app.service.room;

import java.util.List;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.danielmichalski.reservations.business.domain.entity.room.RoomStatusEntity;
import com.danielmichalski.reservations.business.domain.repository.room.RoomStatusRepository;
import com.danielmichalski.reservations.business.dto.room.RoomStatusesCountDto;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
class RoomStatusServiceImpl implements RoomStatusService {

    public static final int STATUS_INDEX = 0;
    public static final int COUNT_INDEX = 1;

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
        return Stream.of(roomStatusesCount)
                .map(this::convertToRoomStatusesCountDto)
                .collect(toList());
    }

    private RoomStatusesCountDto convertToRoomStatusesCountDto(Object[] rsc) {
        String status = (String) rsc[STATUS_INDEX];
        long count = (long) rsc[COUNT_INDEX];
        return new RoomStatusesCountDto(status, count);
    }

}
