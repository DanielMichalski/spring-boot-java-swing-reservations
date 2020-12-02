package com.danielmichalski.reservations.business.app.service.client;

import java.util.List;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.danielmichalski.reservations.business.domain.entity.client.ClientEntity;
import com.danielmichalski.reservations.business.domain.repository.client.ClientRepository;
import com.danielmichalski.reservations.business.dto.client.ClientReservationCountDto;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
class ClientServiceImpl implements ClientService {

    public static final int NAME_INDEX = 0;
    public static final int EMAIL_INDEX = 1;
    public static final int COUNT_INDEX = 2;

    private final ClientRepository clientRepository;

    public List<ClientEntity> findAll() {
        return clientRepository.findAll();
    }

    public void save(ClientEntity client) {
        clientRepository.save(client);
    }

    public void remove(ClientEntity client) {
        clientRepository.delete(client);
    }

    public List<ClientReservationCountDto> getClientReservationsCount() {
        Object[][] clientReservationsCount = clientRepository.getClientReservationsCount();
        return Stream.of(clientReservationsCount)
                .map(this::convertToClientReservationCountDto)
                .collect(toList());
    }

    private ClientReservationCountDto convertToClientReservationCountDto(Object[] crc) {
        String name = (String) crc[NAME_INDEX];
        String email = (String) crc[EMAIL_INDEX];
        long count = (long) crc[COUNT_INDEX];
        return new ClientReservationCountDto(name, email, count);
    }
}
