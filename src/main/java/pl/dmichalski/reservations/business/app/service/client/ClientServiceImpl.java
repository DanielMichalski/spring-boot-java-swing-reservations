package pl.dmichalski.reservations.business.app.service.client;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dmichalski.reservations.business.domain.entity.client.ClientEntity;
import pl.dmichalski.reservations.business.domain.repository.client.ClientRepository;
import pl.dmichalski.reservations.business.dto.client.ClientReservationCountDto;

@Service
@AllArgsConstructor
class ClientServiceImpl implements ClientService {

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
        return Stream.of(clientReservationsCount).map(crc -> new ClientReservationCountDto((String) crc[0], (String) crc[1], (long) crc[2])).collect(Collectors.toList());
    }
}
