package com.wolkensoftware.commonmodule.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationDTO {

	private String userName;

	private String userEmailId;

	private long userPhoneNumber;

	private String userDOB;

	private String gender;

	private String userPassword;

}
