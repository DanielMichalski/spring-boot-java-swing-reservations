package com.danielmichalski.reservations.domain.client.service;

import com.danielmichalski.reservations.domain.client.dto.ClientReservationCountDto;
import com.danielmichalski.reservations.domain.client.entity.ClientEntity;
import com.danielmichalski.reservations.domain.client.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
class ClientServiceImpl implements ClientService {

    public static final int NAME_INDEX = 0;
    public static final int EMAIL_INDEX = 1;
    public static final int COUNT_INDEX = 2;

    private final ClientRepository clientRepository;

    @Override
    public List<ClientEntity> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void save(ClientEntity client) {
        clientRepository.save(client);
    }

    @Override
    public void remove(ClientEntity client) {
        clientRepository.delete(client);
    }

    @Override
    public List<ClientReservationCountDto> getClientReservationsCount() {
        Object[][] clientReservationsCount = clientRepository.getClientReservationsCount();
        return Stream.of(clientReservationsCount)
                .map(this::convertToClientReservationCountDto)
                .collect(toList());
    }

    private ClientReservationCountDto convertToClientReservationCountDto(Object... crc) {
        String name = (String) crc[NAME_INDEX];
        String email = (String) crc[EMAIL_INDEX];
        long count = (long) crc[COUNT_INDEX];
        return new ClientReservationCountDto(name, email, count);
    }
}
