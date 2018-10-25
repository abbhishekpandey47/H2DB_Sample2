package com.sample.service.dbrepository;

import org.springframework.stereotype.Repository;

import com.sample.service.format.Pickup;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PickupRepository extends JpaRepository<Pickup, Long> { 

}
