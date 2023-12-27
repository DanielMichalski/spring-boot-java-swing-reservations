package com.danielmichalski.reservations.service.rate;

import com.danielmichalski.reservations.domain.entity.rate.RateEntity;
import com.danielmichalski.reservations.domain.repository.rate.RateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class RateServiceImpl implements RateService {

    private final RateRepository rateRepository;

    @Override
    public List<RateEntity> findAll() {
        return rateRepository.findAll();
    }

    @Override
    public void remove(RateEntity rate) {
        rateRepository.delete(rate);
    }

    @Override
    public void save(RateEntity rate) {
        rateRepository.save(rate);
    }
}
