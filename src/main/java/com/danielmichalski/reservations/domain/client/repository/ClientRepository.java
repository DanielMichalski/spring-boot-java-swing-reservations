package com.danielmichalski.reservations.domain.client.repository;

import com.danielmichalski.reservations.domain.client.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    @Query("""
            SELECT CONCAT(c.name, ' ', c.surname) AS name, c.email AS email, COUNT(r.id) AS count
            FROM ReservationEntity r JOIN r.client c
            GROUP BY c.id
            HAVING COUNT (r.id) >= 3
            """
    )
    Object[][] getClientReservationsCount();

}
