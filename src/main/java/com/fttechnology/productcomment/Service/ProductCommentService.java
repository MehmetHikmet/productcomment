package com.fttechnology.productcomment.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fttechnology.productcomment.DataAccess.ICommentDal;
import com.fttechnology.productcomment.DataAccess.IProductDal;
import com.fttechnology.productcomment.DataAccess.IUserDal;
import com.fttechnology.productcomment.Entities.Product;
import com.fttechnology.productcomment.Entities.ProductComment;
import com.fttechnology.productcomment.Entities.User;

@Service
public class ProductCommentService implements IProductCommentService{

    @Autowired
	private ICommentDal commentDal;
    
    @Autowired
   	private IProductDal productDal;
    
    @Autowired
   	private IUserDal userDal;
    
	@Override
	public void save(ProductComment productComment) {   
		commentDal.save(productComment);
		
	}
	
	@Override
	public void saveProduct(Product product) {
		productDal.save(product);
		
	}

	@Override
	public void saveUser(User user) {
		userDal.save(user);
		
	}
	   
	@Override
	public List<ProductComment> findAllByUserId(int id) {
		
		return commentDal.findAllByUserId(id);
	}

	@Override
	public List<ProductComment> findAllByProductId(int id) {
	
		return commentDal.findAllByProductId(id);
	}

	@Override
	public List<ProductComment> findByColumnCommentDateBetweenWithProductID(int product_id,LocalDateTime startDate, LocalDateTime endDate) {
		
		
		return commentDal.findByColumnCommentDateBetweenWithProductID(product_id,startDate, endDate);
	}


	@Override
	public List<ProductComment> findByCommentDateBetweenWithUserID(int user_id, LocalDateTime endDate,
			LocalDateTime startDate) {
		return commentDal.findByCommentDateBetweenWithUserID(user_id, endDate, startDate);
	}

	@Override
	public List<Product> findByExpireDateLessThan(LocalDate toDay) {
		return productDal.findByExpireDateLessThan(toDay);
	}

	@Override
	public List<Product> findByExpireDateGreaterThan(LocalDate toDay) {
		return productDal.findByExpireDateGreaterThan(toDay);
	}
	
	@Override
	public List<ProductComment> saveOrUpdate(ProductComment productComment) {
		commentDal.save(productComment);
		return null;
	}

	@Override
	public void deleteById(int commentId) {
	    commentDal.deleteById(commentId);
	}





}
