package com.pack.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.entity.UsersData;
import com.pack.error.UsersDataNotFoundException;
import com.pack.repository.UsersRepo;
import com.pack.request.RequestPayloads;

@Service
public class UsersServiceImpl implements UsersService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UsersRepo repo;
	@Autowired
	private AdharGenerator adharGenerator;

//How to change status code 201 to 400, if ID not created line 30
	@Override
	public String createAdhar(RequestPayloads paylods) {
		UsersData usersData = new UsersData();
		// verify user exist in DB or not ?
		UsersData data = repo.findByEmail(paylods.getEmail());
		if (data != null) {
			return "ID already created with given Email";
		} else {
			String generatedAdhar = "" + adharGenerator.generate();

			usersData.setName(paylods.getName());
			usersData.setEmail(paylods.getEmail());
			usersData.setDob(paylods.getDob());
			usersData.setGendar(paylods.getGendar());
			usersData.setAddress(paylods.getAddress());
			usersData.setMob(paylods.getMob());
			usersData.setAdhar(generatedAdhar);

			repo.save(usersData);
			return "Adhhar created ";
		}
	}

	@Override
	public String getMyAdhar(String email) {
		logger.info("Provided Email is  :" + email);
		UsersData adhar = repo.findByEmail(email);
		if (adhar == null) {
			return "Please create generate your adhar , Adhar doesn't exist";
		}
		return adhar.getAdhar();
	}

	@Override
	public UsersData getUserDetails(String adhar) {
		logger.info("Provided adhar is  :" + adhar);
		UsersData data = repo.findByAdhar(adhar);
		if (data != null)
			return data;
		else
			throw new UsersDataNotFoundException("Adhar doesn't exist");
	}

}
