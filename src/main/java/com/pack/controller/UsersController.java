package com.pack.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pack.entity.UsersData;
import com.pack.request.RequestPayloads;
import com.pack.service.UsersService;

@RestController
public class UsersController {

	@Autowired
	private UsersService service;

	@PostMapping(value = "/createNewAadhar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createAdhar(@Valid @RequestBody RequestPayloads paylods) {
		String adharinfo = service.createAdhar(paylods);
		return new ResponseEntity<>(adharinfo, HttpStatus.CREATED);
	}

	@GetMapping("/getAadharByEmail/{email}")
	public ResponseEntity<String> getAdhar(@PathVariable ("email") String email) {
		String adhar = service.getMyAdhar(email);
		return new ResponseEntity<>(adhar, HttpStatus.OK);
	}
 
	@GetMapping("/getUserByAadhar/{adhar}")
	public ResponseEntity<UsersData> getUsersData(@PathVariable ("adhar") String adhar) {
		UsersData userDetails = service.getUserDetails(adhar);
		return new ResponseEntity<>(userDetails, HttpStatus.OK);
	}

	@GetMapping("/ValidateAadhar/{adhar}")
	public ResponseEntity<Boolean> aadharValidation(@PathVariable ("adhar") String adhar) {
		Boolean status = service.aadharValidation(adhar);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

}
