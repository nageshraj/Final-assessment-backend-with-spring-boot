package com.wolkensoftware.commonmodule.exceptions;

public class UserEmailException extends Exception {

	@Override
	public String toString() {
		return "UserEmail is either not in the right format or violates length constraints";
	}

}
