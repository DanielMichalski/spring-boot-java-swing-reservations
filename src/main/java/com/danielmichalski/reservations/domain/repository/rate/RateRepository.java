package com.danielmichalski.reservations.domain.repository.rate;

import com.danielmichalski.reservations.domain.entity.rate.RateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<RateEntity, Long> {

}
