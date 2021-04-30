package com.wolkensoftware.commonmodule.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolkensoftware.commonmodule.DTO.UserLoginDTO;
import com.wolkensoftware.commonmodule.DTO.UserRegistrationDTO;
import com.wolkensoftware.commonmodule.entity.UserEntity;
import com.wolkensoftware.commonmodule.exceptions.UserEmailException;
import com.wolkensoftware.commonmodule.exceptions.UserGenderException;
import com.wolkensoftware.commonmodule.exceptions.UserNameDuplicateException;
import com.wolkensoftware.commonmodule.exceptions.UserNameException;
import com.wolkensoftware.commonmodule.exceptions.UserPasswordException;
import com.wolkensoftware.commonmodule.exceptions.UserPhoneNumberException;
import com.wolkensoftware.commonmodule.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public UserEntity validateAndRegisterUser(UserRegistrationDTO userRegistrationDTO) {
		// Code snippet for validation and adding a new USER to the Database
		logger.info("INSIDE validateAndRegisterUser()");

		UserEntity userEntity = new UserEntity();

		try {
			logger.info("inside try");
			logger.info("userRegistrationDTO is:" + userRegistrationDTO.getUserName() + " "
					+ userRegistrationDTO.getUserEmailId() + " " + userRegistrationDTO.getGender() + " "
					+ userRegistrationDTO.getUserDOB() + " " + userRegistrationDTO.getUserPhoneNumber()
					+ userRegistrationDTO.getUserPassword());

			if (userRegistrationDTO.getUserName().length() < 6 || userRegistrationDTO.getUserName().length() > 20) {
				logger.info("Inside userName");
				throw new UserNameException(); // UserName is invalid
			} else
				userEntity.setUserName(userRegistrationDTO.getUserName());

			if (userRegistrationDTO.getUserEmailId().length() < 13
					|| userRegistrationDTO.getUserEmailId().length() > 56) {
				logger.info("Inside userEmail");
				throw new UserEmailException(); // UserEmail is invalid

			} else
				userEntity.setUserEmailId(userRegistrationDTO.getUserEmailId());

			if (userRegistrationDTO.getUserPhoneNumber() < 1000000000) {
				logger.info("Inside phone");

				throw new UserPhoneNumberException(); // UserPhoneNumber is invalid
			} else
				userEntity.setUserPhoneNumber(userRegistrationDTO.getUserPhoneNumber());

			if (userRegistrationDTO.getGender().length() < 4 || userRegistrationDTO.getGender().length() > 11)
				throw new UserGenderException(); // UserGender is invalid
			else
				userEntity.setGender(userRegistrationDTO.getGender());

			if (userRegistrationDTO.getUserPassword().length() < 8
					|| userRegistrationDTO.getUserPassword().length() > 20) {
				logger.info("Inside password");

				throw new UserPasswordException(); // UserPassword is invalid
			} else
				userEntity.setUserPassword(userRegistrationDTO.getUserPassword());

			userEntity.setUserDOB(userRegistrationDTO.getUserDOB());

			if (userRepository.findByUserName(userRegistrationDTO.getUserName()) == null)
				return userRepository.save(userEntity);
			else {
				throw new UserNameDuplicateException();
			}
		} catch (UserNameException | UserEmailException | UserPhoneNumberException | UserGenderException
				| UserPasswordException | NullPointerException | UserNameDuplicateException e) {
			logger.error(e.toString());

		}
		return null;

	}

	@Override
	public List<UserEntity> validateAndGetAllUsers() {

		logger.info("Inside validateAndGetAllUsers()");

		return userRepository.findAll();
	}

	@Override
	public UserEntity validateAndLoginUser(UserLoginDTO userLoginDTO) {

		logger.info("Inside validateAndLoginUser()");

		UserEntity userEntity = null;

		try {
			logger.info("inside try");
			if (userLoginDTO.getUserName().length() < 6 || userLoginDTO.getUserName().length() > 20)
				throw new UserNameException();

			if (userLoginDTO.getUserPassword().length() < 8 || userLoginDTO.getUserPassword().length() > 20)
				throw new UserPasswordException();

			userEntity = userRepository.findByUserName(userLoginDTO.getUserName());
//			logger.info("userEntity is" + userEntity);
//			logger.info("userName is" + userEntity.getUserName());

			if (userEntity.getUserPassword().equals(userLoginDTO.getUserPassword())) {
				logger.info("userEntity is" + userEntity);
				return userEntity;
			}

		} catch (UserNameException | UserPasswordException e) {
			logger.error(e.toString());
		}

		return null;
	}

}
