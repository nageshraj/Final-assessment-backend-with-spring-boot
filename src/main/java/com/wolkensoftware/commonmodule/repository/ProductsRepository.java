package com.wolkensoftware.commonmodule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolkensoftware.commonmodule.entity.ProductsEntity;

public interface ProductsRepository extends JpaRepository<ProductsEntity, Integer> {

	public ProductsEntity findByProductName(String productNameSelected);

	public List<ProductsEntity> findByProductType(String productTypeSelected);

}
