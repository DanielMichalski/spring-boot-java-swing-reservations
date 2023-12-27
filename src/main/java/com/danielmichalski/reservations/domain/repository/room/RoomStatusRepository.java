package com.danielmichalski.reservations.domain.repository.room;

import com.danielmichalski.reservations.domain.entity.room.RoomStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomStatusRepository extends JpaRepository<RoomStatusEntity, Long> {

    @Query("""
            SELECT rs.status AS name, COUNT(r.id) AS count
            FROM RoomEntity r
            JOIN r.roomStatus rs
            GROUP BY rs.status
            """
    )
    Object[][] getRoomStatusesCount();

}
