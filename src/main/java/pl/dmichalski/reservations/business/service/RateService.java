package pl.dmichalski.reservations.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmichalski.reservations.business.entity.Rate;
import pl.dmichalski.reservations.business.repository.RateRepository;

import java.util.List;

@Service
public class RateService {

    private RateRepository rateRepository;

    @Autowired
    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public List<Rate> findAll() {
        return rateRepository.findAll();
    }

    public void remove(Rate rate) {
        rateRepository.delete(rate);
    }

    public void save(Rate rate) {
        rateRepository.save(rate);
    }
}
