package com.wolkensoftware.commonmodule.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolkensoftware.commonmodule.DTO.UserLoginDTO;
import com.wolkensoftware.commonmodule.DTO.UserRegistrationDTO;
import com.wolkensoftware.commonmodule.entity.UserEntity;
import com.wolkensoftware.commonmodule.service.UserService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserResources {

	Logger logger = LoggerFactory.getLogger(UserResources.class);

	@Autowired
	UserService userService;

	@PostMapping("/registerUser")
	public ResponseEntity<UserEntity> registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {

		logger.info(
				"userRegistrationDTO is:" + userRegistrationDTO.getUserName() + userRegistrationDTO.getUserEmailId());
		logger.info("INSIDE /registerUser");

		UserEntity userEntity = null;

		try {
			userEntity = userService.validateAndRegisterUser(userRegistrationDTO);
		} catch (NullPointerException e) {
			e.toString();
		}
		if (userEntity != null)
			return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
		else
			return new ResponseEntity<UserEntity>(userEntity, HttpStatus.FAILED_DEPENDENCY);

	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserEntity>> getAllUsers() {

		logger.info("INSIDE /getAllUsers");

		List<UserEntity> allUsers = null;

		try {
			allUsers = userService.validateAndGetAllUsers();
		} catch (NullPointerException e) {
			e.toString();
		}
		if (allUsers != null)
			return new ResponseEntity<List<UserEntity>>(allUsers, HttpStatus.OK);
		else
			return new ResponseEntity<List<UserEntity>>(allUsers, HttpStatus.FAILED_DEPENDENCY);

	}

	@PostMapping("/login")
	public ResponseEntity<UserEntity> loginUser(@RequestBody UserLoginDTO userLoginDTO) {

		logger.info("INSIDE /login");

		UserEntity userEntity = null;

		try {
			userEntity = userService.validateAndLoginUser(userLoginDTO);
		} catch (NullPointerException e) {
			e.toString();
		}
		if (userEntity != null)
			return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
		else
			return new ResponseEntity<UserEntity>(userEntity, HttpStatus.FAILED_DEPENDENCY);
	}
}