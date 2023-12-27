package com.danielmichalski.reservations.service.address;

import com.danielmichalski.reservations.domain.entity.address.AddressEntity;
import com.danielmichalski.reservations.domain.repository.address.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public List<AddressEntity> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public void remove(AddressEntity address) {
        addressRepository.delete(address);
    }

    @Override
    public void save(AddressEntity address) {
        addressRepository.save(address);
    }
}
