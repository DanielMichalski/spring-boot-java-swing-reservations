package com.danielmichalski.reservations.domain.repository.address;

import com.danielmichalski.reservations.domain.entity.address.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

}
