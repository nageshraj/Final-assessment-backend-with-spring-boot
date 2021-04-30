package com.wolkensoftware.commonmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolkensoftware.commonmodule.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	// @Query(nativeQuery = true, value = "select udt.* from user_details_table udt
	// ")
	public UserEntity findByUserName(String name);

}
