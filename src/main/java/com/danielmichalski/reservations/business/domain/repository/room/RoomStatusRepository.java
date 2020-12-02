package com.danielmichalski.reservations.business.domain.repository.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.danielmichalski.reservations.business.domain.entity.room.RoomStatusEntity;

@Repository
public interface RoomStatusRepository extends JpaRepository<RoomStatusEntity, Long> {

    @Query(value = "SELECT rs.status AS name, COUNT(r.id) AS count " +
            "FROM RoomEntity r " +
            "JOIN r.roomStatus rs " +
            "GROUP BY rs.status")
    Object[][] getRoomStatusesCount();

}
