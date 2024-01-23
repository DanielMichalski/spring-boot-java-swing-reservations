package com.danielmichalski.reservations.domain.client.service;

import com.danielmichalski.reservations.domain.client.dto.ClientReservationCountDto;
import com.danielmichalski.reservations.domain.client.entity.ClientEntity;
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
