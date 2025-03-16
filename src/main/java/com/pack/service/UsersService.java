package com.pack.service;

import com.pack.entity.UsersData;
import com.pack.request.RequestPayloads;

public interface UsersService {

	String createAdhar(RequestPayloads paylods);

	String getMyAdhar(String email);

	UsersData getUserDetails(String adhar);


	Boolean aadharValidation(String adhar);
}
