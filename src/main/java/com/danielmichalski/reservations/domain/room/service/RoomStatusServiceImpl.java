package com.danielmichalski.reservations.domain.room.service;

import com.danielmichalski.reservations.domain.room.dto.RoomStatusesCountDto;
import com.danielmichalski.reservations.domain.room.entity.RoomStatusEntity;
import com.danielmichalski.reservations.domain.room.repository.RoomStatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
class RoomStatusServiceImpl implements RoomStatusService {

    public static final int STATUS_INDEX = 0;
    public static final int COUNT_INDEX = 1;

    private final RoomStatusRepository roomStatusRepository;

    @Override
    public List<RoomStatusEntity> findAll() {
        return roomStatusRepository.findAll();
    }

    @Override
    public void remove(RoomStatusEntity roomStatus) {
        roomStatusRepository.delete(roomStatus);
    }

    @Override
    public void save(RoomStatusEntity roomStatus) {
        roomStatusRepository.save(roomStatus);
    }

    @Override
    public List<RoomStatusesCountDto> getRoomStatusesCount() {
        Object[][] roomStatusesCount = roomStatusRepository.getRoomStatusesCount();
        return Stream.of(roomStatusesCount)
                .map(this::convertToRoomStatusesCountDto)
                .collect(toList());
    }

    private RoomStatusesCountDto convertToRoomStatusesCountDto(Object... rsc) {
        String status = (String) rsc[STATUS_INDEX];
        long count = (long) rsc[COUNT_INDEX];
        return new RoomStatusesCountDto(status, count);
    }

}
