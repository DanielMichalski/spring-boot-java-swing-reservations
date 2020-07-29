package pl.dmichalski.reservations.business.app.service.rate;

import java.util.List;

import pl.dmichalski.reservations.business.domain.entity.rate.RateEntity;
import pl.dmichalski.reservations.business.util.annotation.TransactionalReadOnly;
import pl.dmichalski.reservations.business.util.annotation.TransactionalWrite;

public interface RateService {

    @TransactionalReadOnly
    List<RateEntity> findAll();

    @TransactionalWrite
    void remove(RateEntity rate);

    @TransactionalWrite
    void save(RateEntity rate);
}
