package pl.dmichalski.reservations.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmichalski.reservations.business.entity.Client;
import pl.dmichalski.reservations.business.entity.domain.ClientReservationCount;
import pl.dmichalski.reservations.business.repository.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public void save(Client client) {
        clientRepository.save(client);
    }

    public void remove(Client client) {
        clientRepository.delete(client);
    }

    public List<ClientReservationCount> getClientReservationsCount() {
        Object[][] clientReservationsCount = clientRepository.getClientReservationsCount();
        return Stream.of(clientReservationsCount).map(crc -> new ClientReservationCount((String) crc[0], (String) crc[1], (long) crc[2])).collect(Collectors.toList());
    }
}
