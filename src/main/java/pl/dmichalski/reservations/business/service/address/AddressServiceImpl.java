package pl.dmichalski.reservations.business.service.address;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dmichalski.reservations.business.domain.entity.address.AddressEntity;
import pl.dmichalski.reservations.business.domain.repository.address.AddressRepository;

@Service
@AllArgsConstructor
class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public List<AddressEntity> findAll() {
        return addressRepository.findAll();
    }

    public void remove(AddressEntity address) {
        addressRepository.delete(address);
    }

    public void save(AddressEntity address) {
        addressRepository.save(address);
    }
}
