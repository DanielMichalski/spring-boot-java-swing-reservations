package pl.dmichalski.reservations.business.domain.repository.rate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmichalski.reservations.business.domain.entity.rate.RateEntity;

@Repository
public interface RateRepository extends JpaRepository<RateEntity, Long> {
}
