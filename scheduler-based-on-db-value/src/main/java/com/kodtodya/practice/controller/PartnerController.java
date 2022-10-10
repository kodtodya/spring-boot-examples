package com.kodtodya.practice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.kodtodya.practice.model.Partner;
import com.kodtodya.practice.repository.PartnerRepository;
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
	PartnerRepository partnerRepository;

	@GetMapping("/partner")
	public ResponseEntity<List<Partner>> getAllPartners(@RequestParam(required = false) String name) {
		try {
			List<Partner> partners = new ArrayList<Partner>();

			if (name == null)
				partnerRepository.findAll().forEach(partners::add);
			else
				partnerRepository.findByName(name).forEach(partners::add);

			if (partners.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(partners, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/partner/{id}")
	public ResponseEntity<Partner> getPartnerById(@PathVariable("id") long id) {
		Optional<Partner> partner = partnerRepository.findById(id);

		if (partner.isPresent()) {
			return new ResponseEntity<>(partner.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/partner")
	public ResponseEntity<Partner> createPartner(@RequestBody Partner partner) {
		try {
			Partner _partner = partnerRepository
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
		Optional<Partner> PartnerData = partnerRepository.findById(id);

		if (PartnerData.isPresent()) {
			Partner _partner = PartnerData.get();
			_partner.setName(partner.getName());
			_partner.setEmail(partner.getEmail());
			_partner.setScheduler(partner.getScheduler());
			return new ResponseEntity<>(partnerRepository.save(_partner), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/partner/{id}")
	public ResponseEntity<HttpStatus> deletePartner(@PathVariable("id") long id) {
		try {
			partnerRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/Partners")
	public ResponseEntity<HttpStatus> deleteAllPartners() {
		try {
			partnerRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
