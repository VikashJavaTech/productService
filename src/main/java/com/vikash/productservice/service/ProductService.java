package com.vikash.productservice.service;

import java.util.List;

import com.vikash.productservice.entity.ProductEntity;

public interface ProductService {
	ProductEntity saveProduct(ProductEntity entity);

	ProductEntity findProductById(Long id);

	Integer findProductQuantityById(Long id);

	List<ProductEntity> findAllProduct();

	List<ProductEntity> getProductByName(String name);

	String deleteProductById(Long id);

	Double getPriceById(Long id);

	ProductEntity updateProduct(ProductEntity entity, Long id);

	List<ProductEntity> findAllProductServiceByName();

	List<ProductEntity> findInRange(Double p1, Double p2);

}
