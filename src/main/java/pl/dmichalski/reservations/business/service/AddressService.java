package pl.dmichalski.reservations.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmichalski.reservations.business.entity.Address;
import pl.dmichalski.reservations.business.repository.AddressRepository;

import java.util.List;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public void remove(Address address) {
        addressRepository.delete(address);
    }

    public void save(Address address) {
        addressRepository.save(address);
    }
}
