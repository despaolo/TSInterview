package com.teamSystem.usermanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamSystem.usermanager.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByFiscalCode(String fiscalCode);
}
