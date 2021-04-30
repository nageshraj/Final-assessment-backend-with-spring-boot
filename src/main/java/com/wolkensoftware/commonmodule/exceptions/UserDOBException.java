package com.wolkensoftware.commonmodule.exceptions;

public class UserDOBException extends Exception {

	@Override
	public String toString() {
		return "UserDOB is either not in the right format or violates length constraints";

	}

}
