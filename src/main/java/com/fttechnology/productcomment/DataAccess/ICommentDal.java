package com.fttechnology.productcomment.DataAccess;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fttechnology.productcomment.Entities.ProductComment;

public interface ICommentDal extends JpaRepository<ProductComment, Integer>{
	List<ProductComment> findAllByUserId(int id);
	List<ProductComment> findAllByProductId(int id);
	List<ProductComment> findByColumnCommentDateBetweenWithProductID(int product_id, LocalDateTime startDate, LocalDateTime endDate);
	List<ProductComment> findByCommentDateBetweenWithUserID(int user_id, LocalDateTime startDate, LocalDateTime endDate);
}


