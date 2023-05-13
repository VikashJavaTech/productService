package com.vikash.productservice.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikash.productservice.entity.ProductEntity;
import com.vikash.productservice.reposistory.ProductReposistory;
import com.vikash.productservice.service.ProductService;


@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	public ProductReposistory productReposistory;
	
	@Override
	public ProductEntity saveProduct(ProductEntity entity) {
		return productReposistory.saveProduct(entity);
	}

	@Override
	public ProductEntity findProductById(Long id) {
		
		return productReposistory.findProductById(id);
	}

	@Override
	public Integer findProductQuantityById(Long id) {
		return productReposistory.findProductQuantityById(id);
	}

	@Override
	public String deleteProductById(Long id) {
		return productReposistory.deleteProductById(id);
	}

	@Override
	public ProductEntity updateProduct(ProductEntity entity,Long id) {
		
		return productReposistory.updateProduct(entity, id);
	}

	@Override
	public List<ProductEntity> findAllProductServiceByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductEntity> getProductByName(String name) {
		return productReposistory.getProductByName(name);
		
	}

	@Override
	public List<ProductEntity> findInRange(Double p1, Double p2) {
		
		return productReposistory.findInRange(p1,p2);
	}

	@Override
	public List<ProductEntity> findAllProduct() {
		return productReposistory.findallProduct();
	}

	@Override
	public Double getPriceById(Long id) {
		
		return productReposistory.getPriceById(id);
	}

	

}
