package pl.dmichalski.reservations.business.service.client;

import java.util.List;

import pl.dmichalski.reservations.business.domain.entity.client.ClientEntity;
import pl.dmichalski.reservations.business.dto.client.ClientReservationCountDto;
import pl.dmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import pl.dmichalski.reservations.business.util.annotation.TransactionalWrite;

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
