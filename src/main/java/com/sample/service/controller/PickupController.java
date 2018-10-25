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

import com.sample.service.dbrepository.PickupRepository;
import com.sample.service.format.Pickup;


@RestController
@RequestMapping("/pickup")
public class PickupController {
	
	@Autowired
	PickupRepository pickRepo;
	
	@PostMapping("/createPickup")
	private ResponseEntity<Object> create(@RequestBody Pickup pickupRequest)
	{
		Pickup savedPickup = pickRepo.save(pickupRequest);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPickup.getPickupId()).toUri();

		return ResponseEntity.created(location).build();	
	}
	
	@PutMapping("/updatePickup/{id}")
	private ResponseEntity<Object> update(@PathVariable long id, @RequestBody Pickup pickup)
	{
		Optional<Pickup> pickupOptional = pickRepo.findById(id);

		if (!pickupOptional.isPresent())
			return ResponseEntity.notFound().build();

		pickup.setPickupId(id);
		
		pickRepo.save(pickup);

		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("deletePickup/{id}")
	private void delete(@PathVariable long id)
	{
		pickRepo.deleteById(id);
	}
	
	@PostMapping("/getPickupDetails/{id}")
	private Pickup getDeliveryDetails(@PathVariable long id)
	{
		Optional<Pickup> pickup = pickRepo.findById(id);

		return pickup.get();
	}
	
	@GetMapping("/getPickupList")
	private List<Pickup> getPickupList()
	{
		return pickRepo.findAll();
	}
}

