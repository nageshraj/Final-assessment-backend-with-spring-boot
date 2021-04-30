package com.wolkensoftware.commonmodule.exceptions;

public class ProductRatingException extends Exception {

	@Override
	public String toString() {
		return "ProductRating is either not an Integer or not between the range(1-5)";

	}

}
