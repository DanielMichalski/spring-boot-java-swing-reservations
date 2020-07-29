package pl.dmichalski.reservations.business.app.service.address;

import java.util.List;

import pl.dmichalski.reservations.business.domain.entity.address.AddressEntity;
import pl.dmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import pl.dmichalski.reservations.business.util.annotation.TransactionalWrite;

public interface AddressService {

    @TransactionalReadOnly
    List<AddressEntity> findAll();

    @TransactionalWrite
    void remove(AddressEntity address);

    @TransactionalWrite
    void save(AddressEntity address);
}
