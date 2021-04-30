package com.wolkensoftware.commonmodule.service;

import java.util.List;

import com.wolkensoftware.commonmodule.DTO.ProductsDTO;
import com.wolkensoftware.commonmodule.entity.ProductsEntity;

public interface ProductsService {

	public ProductsEntity validateAndAddProduct(ProductsDTO productsDTO);

	public List<ProductsEntity> validateAndGetAllProducts();

	public List<ProductsEntity> validateAndGetProductsByType(String productTypeSelected);

}
