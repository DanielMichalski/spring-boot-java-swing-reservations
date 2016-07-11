package pl.dmichalski.reservations.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.dmichalski.reservations.business.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "SELECT concat(c.name, ' ', c.surname) AS name, c.email AS email, COUNT(r.id) AS count " +
            "FROM Reservation r JOIN r.client c " +
            "GROUP BY c.id " +
            "HAVING COUNT (r.id) >= 3")
    Object[][] getClientReservationsCount();

}