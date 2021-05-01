package com.wolkensoftware.commonmodule.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolkensoftware.commonmodule.DTO.ProductsDTO;
import com.wolkensoftware.commonmodule.entity.ProductsEntity;
import com.wolkensoftware.commonmodule.exceptions.ProductAvailabilityException;
import com.wolkensoftware.commonmodule.exceptions.ProductNameException;
import com.wolkensoftware.commonmodule.exceptions.ProductPriceException;
import com.wolkensoftware.commonmodule.exceptions.ProductQuantityException;
import com.wolkensoftware.commonmodule.exceptions.ProductRatingException;
import com.wolkensoftware.commonmodule.exceptions.ProductTypeException;
import com.wolkensoftware.commonmodule.repository.ProductsRepository;

@Service
public class ProductsServiceImpl implements ProductsService {

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	ProductsRepository productsRepository;

	@Override
	public ProductsEntity validateAndAddProduct(ProductsDTO productsDTO) {

		logger.info("INSIDE validateAndAddPerson()");

		ProductsEntity productsEntity = new ProductsEntity();

		try {

			if (productsDTO.getProductName().length() < 5 || productsDTO.getProductName().length() > 50)
				throw new ProductNameException(); // ProductName is invalid
			else
				productsEntity.setProductName(productsDTO.getProductName());

			if (productsDTO.getProductType().length() < 5 || productsDTO.getProductType().length() > 45)
				throw new ProductTypeException(); // ProductType is invalid
			else
				productsEntity.setProductType(productsDTO.getProductType());

			if (productsDTO.getProductPrice() < 0 || productsDTO.getProductPrice() > 9999999)
				throw new ProductPriceException(); // ProductPrice is invalid
			else
				productsEntity.setProductPrice(productsDTO.getProductPrice());

			if (productsDTO.getProductQuantity() < 0 || productsDTO.getProductQuantity() > 999)
				throw new ProductQuantityException(); // ProductQuantity is invalid
			else
				productsEntity.setProductQuantity(productsDTO.getProductQuantity());

			if (productsDTO.getProductAvailability().equals("YES") || productsDTO.getProductAvailability().equals("NO"))
				productsEntity.setProductAvailability(productsDTO.getProductAvailability());
			else
				throw new ProductAvailabilityException(); // ProductAvailability is invalid

			if (productsDTO.getProductRating() < 1 || productsDTO.getProductRating() > 5)
				throw new ProductRatingException(); // ProductRating is invalid
			else
				productsEntity.setProductRating(productsDTO.getProductRating());

			// If product with same name exists already, increases the quantity of product
			// instead of adding it again

			ProductsEntity existingProductEntity = productsRepository
					.findByProductName(productsEntity.getProductName());
			if (existingProductEntity == null)
				return productsRepository.save(productsEntity);
			else {
				existingProductEntity.setProductName(productsEntity.getProductName());
				existingProductEntity.setProductType(productsEntity.getProductType());
				existingProductEntity.setProductAvailability(productsEntity.getProductAvailability());
				existingProductEntity.setProductPrice(productsEntity.getProductPrice());
				existingProductEntity.setProductRating(productsEntity.getProductRating());
				existingProductEntity.setProductQuantity(productsEntity.getProductQuantity());

				return productsRepository.save(existingProductEntity);

			}

		} catch (ProductNameException | ProductTypeException | ProductPriceException | ProductQuantityException
				| ProductAvailabilityException | ProductRatingException e) {
			logger.error(e.toString());

		}
		return null;

	}

	@Override
	public List<ProductsEntity> validateAndGetAllProducts() {

		logger.info("Inside validateAndGetAllProducts()");

		return productsRepository.findAll();
	}

	@Override
	public List<ProductsEntity> validateAndGetProductsByType(String productTypeSelected) {

		logger.info("Inside validateAndGetProductsByType()");

		List<ProductsEntity> productsEntities = null;

		try {
			if (productTypeSelected.length() < 5 || productTypeSelected.length() > 45)
				throw new ProductTypeException(); // ProductType is invalid
			else
				return productsRepository.findByProductType(productTypeSelected);
		} catch (ProductTypeException | NullPointerException e) {
			logger.error(e.toString());
		}

		return null;
	}

	@Override
	public ProductsEntity validateAndGetProductByName(String name) {

		logger.info("Inside validateAndGetProductByName()");

		ProductsEntity productsEntity = null;

		try {
			if (name.length() < 5 || name.length() > 50)
				throw new ProductNameException(); // ProductType is invalid
			else
				return productsRepository.findByProductName(name);
		} catch (ProductNameException | NullPointerException e) {
			logger.error(e.toString());
		}

		return null;
	}

	@Override
	public Integer validateAndDeleteByName(String name) {
		logger.info("Inside validateAndDeleteByName()");

		ProductsEntity productsEntity = null;

		try {
			if (name.length() < 5 || name.length() > 50)
				throw new ProductNameException(); // ProductType is invalid
			else

				return productsRepository.deleteByProductName(name);
		} catch (ProductNameException | NullPointerException e) {
			logger.error(e.toString());
		}

		return null;
	}

}
