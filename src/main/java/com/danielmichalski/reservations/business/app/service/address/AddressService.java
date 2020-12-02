package com.danielmichalski.reservations.business.app.service.address;

import java.util.List;

import com.danielmichalski.reservations.business.domain.entity.address.AddressEntity;
import com.danielmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import com.danielmichalski.reservations.business.util.annotation.TransactionalWrite;

public interface AddressService {

    @TransactionalReadOnly
    List<AddressEntity> findAll();

    @TransactionalWrite
    void remove(AddressEntity address);

    @TransactionalWrite
    void save(AddressEntity address);
}
