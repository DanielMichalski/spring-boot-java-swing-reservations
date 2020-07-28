package pl.dmichalski.reservations.business.service.rate;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dmichalski.reservations.business.domain.entity.rate.RateEntity;
import pl.dmichalski.reservations.business.domain.repository.rate.RateRepository;

@Service
@AllArgsConstructor
class RateServiceImpl implements RateService {

    private final RateRepository rateRepository;

    public List<RateEntity> findAll() {
        return rateRepository.findAll();
    }

    public void remove(RateEntity rate) {
        rateRepository.delete(rate);
    }

    public void save(RateEntity rate) {
        rateRepository.save(rate);
    }
}
