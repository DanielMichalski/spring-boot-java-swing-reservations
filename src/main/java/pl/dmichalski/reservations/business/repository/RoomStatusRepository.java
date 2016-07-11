package pl.dmichalski.reservations.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.dmichalski.reservations.business.entity.RoomStatus;

@Repository
public interface RoomStatusRepository extends JpaRepository<RoomStatus, Long> {

    @Query(value = "SELECT rs.roomStatus AS name, COUNT(r.id) AS count FROM Room r JOIN r.roomStatus rs GROUP BY rs.roomStatus")
    Object[][] getRoomStatusesCount();

}