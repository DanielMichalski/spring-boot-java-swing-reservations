package com.danielmichalski.reservations.domain.address.repository;

import com.danielmichalski.reservations.domain.address.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

}
