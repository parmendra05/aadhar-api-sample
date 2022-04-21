package com.pack.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pack.entity.UsersData;
@DataJpaTest
class UsersRepoTest {

	@Autowired
	UsersRepo repository;
	
	UsersData userData;
	
	@BeforeEach
	public void setup() {
		
		userData=new UsersData();
		userData.setName("ajay");
		userData.setAddress("abc tower , delhi");
		userData.setAdhar("1234");
		userData.setDob(null);
		userData.setGendar("Male");
		userData.setEmail("a@gm.com");	
		
	}

	@Test
	public void testSaveEmployee() {
		UsersData data= repository.save(userData);
			Assertions.assertThat(data).isNotNull();
	}
	
	@Test
	public void testFindByEmail() {
		repository.save(userData);
		
		UsersData data= repository.findByEmail("a@gm.com");
			Assertions.assertThat(data).isNotNull();
			Assertions.assertThat("ajay").isEqualTo(data.getName());
	}
	
	@Test
	public void testFindByAdhar() {
		repository.save(userData);
		
		UsersData data= repository.findByAdhar("1234");
			Assertions.assertThat(data).isNotNull();
			Assertions.assertThat("ajay").isEqualTo(data.getName());
	}
	
}
