package com.wolkensoftware.commonmodule.exceptions;

public class UserPhoneNumberException extends Exception {
	@Override
	public String toString() {
		return "UserPhoneNumber is either not in the right format or violates length constraints";
	}
}
