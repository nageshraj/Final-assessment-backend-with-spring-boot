package com.wolkensoftware.commonmodule.service;

import java.util.List;

import com.wolkensoftware.commonmodule.DTO.UserLoginDTO;
import com.wolkensoftware.commonmodule.DTO.UserRegistrationDTO;
import com.wolkensoftware.commonmodule.entity.UserEntity;

public interface UserService {

	public UserEntity validateAndRegisterUser(UserRegistrationDTO userRegistrationDTO);

	public List<UserEntity> validateAndGetAllUsers();

	public UserLoginDTO validateAndLoginUser(UserLoginDTO userLoginDTO);

}
