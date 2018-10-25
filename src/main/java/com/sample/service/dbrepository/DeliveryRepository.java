package com.sample.service.dbrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.service.format.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
	
}
