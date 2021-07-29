package com.example.demo.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.Suspect;
import com.example.demo.service.SuspectService;

@RestController
@CrossOrigin
public class SuspectController {

	private SuspectService service;
	
	public SuspectController(SuspectService service) {
		super();
		this.service =service;
	}
	
	@PostMapping("/createSuspect") // fancy
	public ResponseEntity<Suspect> createKitten(@RequestBody Suspect Suspect) { // less fancy
		Suspect created = this.service.createSuspect(Suspect);
		return new ResponseEntity<>(created, HttpStatus.CREATED); // body, code
	}

	@GetMapping("/getAllSuspects")
	public List<Suspect> getAllSuspects() {
		return this.service.getAllSuspects();
	}

	@GetMapping("/getByName/{name}")
	public List<Suspect> getByName(@PathVariable String name) {
		return this.service.getByName(name);
	}

	@GetMapping("/getSuspect/{id}")
	public Suspect getSuspect(@PathVariable int id) {
		return this.service.getSuspect(id);
	}

	@PutMapping("/updateSuspect/{id}")
	public ResponseEntity<Suspect> updateSuspect(@PathVariable int id, @RequestBody Suspect newSuspect) {
		Suspect body = this.service.replaceSuspect(id, newSuspect);
		return new ResponseEntity<Suspect>(body, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteSuspect/{id}")
	public ResponseEntity<String> deleteSuspect(@PathVariable int id) {
		String body = this.service.deleteSuspect(id);
		return new ResponseEntity<String>(body, HttpStatus.NO_CONTENT);
	}
}
