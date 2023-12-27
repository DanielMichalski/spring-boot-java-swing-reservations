package com.danielmichalski.reservations.service.address;

import com.danielmichalski.reservations.domain.entity.address.AddressEntity;
import com.danielmichalski.reservations.util.annotation.TransactionalReadOnly;
import com.danielmichalski.reservations.util.annotation.TransactionalWrite;

import java.util.List;

public interface AddressService {

    @TransactionalReadOnly
    List<AddressEntity> findAll();

    @TransactionalWrite
    void remove(AddressEntity address);

    @TransactionalWrite
    void save(AddressEntity address);
}
