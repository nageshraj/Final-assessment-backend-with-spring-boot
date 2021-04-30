package com.wolkensoftware.commonmodule.exceptions;

public class UserGenderException extends Exception {
	@Override
	public String toString() {
		return "UserGender is either not in the right format or violates length constraints";

	}

}
