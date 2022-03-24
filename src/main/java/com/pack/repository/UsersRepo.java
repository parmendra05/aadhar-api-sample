package com.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.entity.UsersData;
//@Repository
public interface UsersRepo extends JpaRepository<UsersData, Integer> {
	public UsersData findByEmail(String email);
	public UsersData findByAdhar(String adhar);
}
