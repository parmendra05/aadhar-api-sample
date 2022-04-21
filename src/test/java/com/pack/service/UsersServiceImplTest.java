package com.pack.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pack.repository.UsersRepo;

@ExtendWith(MockitoExtension.class)
class UsersServiceImplTest {

	@InjectMocks
	private UsersService service;
	
	@Mock
	private UsersRepo repository;
	


}
