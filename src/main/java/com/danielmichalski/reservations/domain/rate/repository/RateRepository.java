package com.danielmichalski.reservations.domain.rate.repository;

import com.danielmichalski.reservations.domain.rate.entity.RateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<RateEntity, Long> {

}
