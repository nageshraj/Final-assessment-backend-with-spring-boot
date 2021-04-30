package com.wolkensoftware.commonmodule.exceptions;

public class ProductNameException extends Exception {
	@Override
	public String toString() {
		return "ProductName is either not in the right format or violates length constraints";

	}
}
