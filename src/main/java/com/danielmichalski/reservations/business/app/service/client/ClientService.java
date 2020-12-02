package com.danielmichalski.reservations.business.app.service.client;

import java.util.List;

import com.danielmichalski.reservations.business.domain.entity.client.ClientEntity;
import com.danielmichalski.reservations.business.dto.client.ClientReservationCountDto;
import com.danielmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import com.danielmichalski.reservations.business.util.annotation.TransactionalWrite;

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
