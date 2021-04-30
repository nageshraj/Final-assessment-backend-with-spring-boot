package com.wolkensoftware.commonmodule.exceptions;

public class ProductAvailabilityException extends Exception {

	@Override
	public String toString() {
		return "ProductAvailabilty can only be YES or NO";

	}

}
