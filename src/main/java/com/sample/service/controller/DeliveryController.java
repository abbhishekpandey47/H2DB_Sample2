package com.sample.service.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sample.service.dbrepository.DeliveryRepository;
import com.sample.service.format.Delivery;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
	
	
	@Autowired
	DeliveryRepository delRepo;
	
	@PostMapping("/createDelivery")
	private ResponseEntity<Object> create(@RequestBody Delivery deliveryObjectRequest)
	{
		Delivery savedDelivery = delRepo.save(deliveryObjectRequest);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedDelivery.getDeliveryId()).toUri();

		return ResponseEntity.created(location).build();	
	}
	
	@PutMapping("/updateDelivery/{id}")
	private ResponseEntity<Object> update(@PathVariable long id, @RequestBody Delivery delivery)
	{
		Optional<Delivery> deliveryOptional = delRepo.findById(id);

		if (!deliveryOptional.isPresent())
			return ResponseEntity.notFound().build();

		delivery.setDeliveryId(id);
		
		delRepo.save(delivery);

		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("deleteDelivery/{id}")
	private void delete(@PathVariable long id)
	{
		delRepo.deleteById(id);
	}
	
	@PostMapping("/getDeliveryDetails/{id}")
	private Delivery getDeliveryDetails(@PathVariable long id)
	{
		Optional<Delivery> delivery = delRepo.findById(id);

		return delivery.get();
	}
	
	@GetMapping("/getDeliveryList")
	private List<Delivery> getDeliveryList()
	{
		return delRepo.findAll();
	}
}
