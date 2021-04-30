package com.wolkensoftware.commonmodule.exceptions;

public class UserNameDuplicateException extends Exception {
	@Override
	public String toString() {

		return "UserName Exists in the DataBase";
	}

}
