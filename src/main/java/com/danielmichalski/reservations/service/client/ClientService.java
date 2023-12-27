package com.danielmichalski.reservations.service.client;

import com.danielmichalski.reservations.domain.entity.client.ClientEntity;
import com.danielmichalski.reservations.dto.client.ClientReservationCountDto;
import com.danielmichalski.reservations.util.annotation.TransactionalReadOnly;
import com.danielmichalski.reservations.util.annotation.TransactionalWrite;

import java.util.List;

public interface ClientService {

    @TransactionalReadOnly
    List<ClientEntity> findAll();

    @TransactionalWrite
    void save(ClientEntity client);

    @TransactionalWrite
    void remove(ClientEntity client);

    @TransactionalReadOnly
    List<ClientReservationCountDto> getClientReservationsCount();
}
