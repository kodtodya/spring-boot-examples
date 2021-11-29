package com.kodtodya.practice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.kodtodya.practice.model.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PartnerController {

	@Autowired
	com.kodtodya.practice.repository.PartnerRepository PartnerRepository;

	@GetMapping("/partner")
	public ResponseEntity<List<Partner>> getAllPartners(@RequestParam(required = false) String name) {
		try {
			List<Partner> Partners = new ArrayList<Partner>();

			if (name == null)
				PartnerRepository.findAll().forEach(Partners::add);
			else
				PartnerRepository.findByName(name).forEach(Partners::add);

			if (Partners.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(Partners, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/partner/{id}")
	public ResponseEntity<Partner> getPartnerById(@PathVariable("id") long id) {
		Optional<Partner> partner = PartnerRepository.findById(id);

		if (partner.isPresent()) {
			return new ResponseEntity<>(partner.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/partner")
	public ResponseEntity<Partner> createPartner(@RequestBody Partner partner) {
		try {
			Partner _partner = PartnerRepository
					.save(
							new Partner(partner.getId(), partner.getName(), partner.getEmail(), partner.getScheduler())
					);
			return new ResponseEntity<>(_partner, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/partner/{id}")
	public ResponseEntity<Partner> updatePartner(@PathVariable("id") long id, @RequestBody Partner partner) {
		Optional<Partner> PartnerData = PartnerRepository.findById(id);

		if (PartnerData.isPresent()) {
			Partner _partner = PartnerData.get();
			_partner.setName(partner.getName());
			_partner.setEmail(partner.getEmail());
			_partner.setScheduler(partner.getScheduler());
			return new ResponseEntity<>(PartnerRepository.save(_partner), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/partner/{id}")
	public ResponseEntity<HttpStatus> deletePartner(@PathVariable("id") long id) {
		try {
			PartnerRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/Partners")
	public ResponseEntity<HttpStatus> deleteAllPartners() {
		try {
			PartnerRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
