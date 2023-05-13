package com.vikash.productservice.reposistory;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vikash.productservice.entity.ProductEntity;

@Repository
public class ProductReposistory {

	@Autowired
	private SessionFactory sessionFactory;

	public ProductEntity saveProduct(ProductEntity productEntity) {
		ProductEntity product = null;
		try {
			Session session = sessionFactory.openSession();
			Transaction Transaction = session.beginTransaction();
			product = (ProductEntity) session.merge(productEntity);
			Transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	public ProductEntity findProductById(Long id) {

		Session session = sessionFactory.openSession();
		ProductEntity entity = session.find(ProductEntity.class, id);
		session.close();
		return entity;
	}

	public List<ProductEntity> findallProduct() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from ProductEntity");
		return query.getResultList();
		

	}

	public Integer findProductQuantityById(Long id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select quantity from ProductEntity where altKey=:n");
		query.setParameter("n", id);
		Integer quantity = (Integer) query.uniqueResult();
		session.close();
		return quantity;
	}

	public String deleteProductById(Long id) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" delete from ProductEntity where altKey=:key ");
		query.setParameter("key",id);
		query.executeUpdate();
		session.close();
		transaction.commit();
		return "Delete Sueccessful";
	}

	public ProductEntity updateProduct(ProductEntity entity, Long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		return entity;

	}

	public List<ProductEntity> getProductByName(String name) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from ProductEntity where name=:name");
		query.setParameter("name", name);
		List list = query.getResultList();
		return list;

	}

	public List<ProductEntity> findInRange(Double p1, Double p2) {
		Session session = sessionFactory.openSession();
		List<ProductEntity> list = new ProductReposistory().findallProduct();
		List<ProductEntity> range=new ArrayList<>();
		for(ProductEntity product:list)
		{
			if(p1>product.getPrice()&& p1<product.getPrice())
				range.add(product);
		}
		return range;
	}
	
	
	public Double getPriceById(Long id)
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select price from ProductEntity where altKey=:id");
		query.setParameter("id", id);
		Double price = (Double) query.uniqueResult();
		return price; 
		
	}
}
