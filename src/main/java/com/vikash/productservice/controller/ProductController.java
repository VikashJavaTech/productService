package com.vikash.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vikash.productservice.entity.ProductEntity;
import com.vikash.productservice.service.imp.ProductServiceImp;

@RestController
public class ProductController {

	@Autowired
	public ProductServiceImp productServiceImp;
	//working
	@RequestMapping(value = "/saveproduct")
	public ProductEntity saveProduct(ProductEntity entity) {
		ProductEntity product = productServiceImp.saveProduct(entity);
		return product;
	}
	//working
	@GetMapping("/all")
	public List<ProductEntity> getAllProduct()
	{
		return productServiceImp.findAllProduct();
	}
	//working
	@GetMapping(value = "/getProduct/{altkey}")
	public ProductEntity findProductById(@PathVariable("altkey") Long id) {
		ProductEntity product = productServiceImp.findProductById(id);
		return product;
	}
	//working
	@GetMapping("/findProuctPriceById/{altKey}")
	public Double getAmountById(@PathVariable("altKey") Long id)
	{
		return productServiceImp.getPriceById(id);
	}
	//working
	
	@GetMapping(value = "/getproductbyname")
	public  List<ProductEntity> getProductByName(@RequestParam("name") String name) {
		return productServiceImp.getProductByName(name);
	}
	
	@GetMapping(value = "/productbetrange")
	public @ResponseBody List<ProductEntity> productInRange(@RequestParam("lowerPrice") Double lowerPrice,@RequestParam("higherPrice") Double higherPrice) {
		return productServiceImp.findInRange(lowerPrice,higherPrice);
	}
	
	@GetMapping(value = "/getQuantity/{altkey}")
	public  Integer findProductQuantityById(@PathVariable("altkey") Long id) {
		productServiceImp.findProductQuantityById(id);
		return null;
	}

	@DeleteMapping(value = "/deleteProduct/{altkey}")
	public  String deleteProductById(@PathVariable("altkey") Long id) {
		return productServiceImp.deleteProductById(id);
	}

	@PutMapping(value = "/updateProduct/{altkey}")
	public  ProductEntity updateProduct(@RequestBody ProductEntity entity,
			@PathVariable("altkey") Long id) {
		return productServiceImp.updateProduct(entity, id);
	}

	public List<ProductEntity> findAllProductServiceByName() {
		return null;
	}

	

	

}
