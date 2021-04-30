package com.wolkensoftware.commonmodule.exceptions;

public class UserNameException extends Exception {

	@Override
	public String toString() {

		return "UserName is either not in the right format or violates length constraints";
	}

}
