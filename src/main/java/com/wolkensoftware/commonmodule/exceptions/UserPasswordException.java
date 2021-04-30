package com.wolkensoftware.commonmodule.exceptions;

public class UserPasswordException extends Exception {
	@Override
	public String toString() {
		return "UserPassword is either not in the right format or violates length constraints";

	}

}
