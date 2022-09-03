package com.fttechnology.productcomment.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.fttechnology.productcomment.Entities.Product;
import com.fttechnology.productcomment.Entities.ProductComment;
import com.fttechnology.productcomment.Entities.User;

public interface IProductCommentService {
	
	void save(ProductComment productComment);
	void saveProduct(Product product);
	void saveUser(User user);
	List<ProductComment> findAllByUserId(int id);
	List<ProductComment> findAllByProductId(int id);
	List<ProductComment> findByCommentDateBetweenWithProductID(int product_id,LocalDateTime startDate, LocalDateTime endDate);
	List<ProductComment> findByCommentDateBetweenWithUserID(int user_id, LocalDateTime startDate, LocalDateTime endDate);
	List<Product> findByExpireDateLessThan(LocalDate toDay);
	List<Product> findByExpireDateGreaterThan(LocalDate toDay);
	List<ProductComment> saveOrUpdate(ProductComment productComment);
	void deleteById(int commentId);
	
}
