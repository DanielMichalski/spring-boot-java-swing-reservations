package com.danielmichalski.reservations.business.domain.repository.rate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.danielmichalski.reservations.business.domain.entity.rate.RateEntity;

@Repository
public interface RateRepository extends JpaRepository<RateEntity, Long> {
}
