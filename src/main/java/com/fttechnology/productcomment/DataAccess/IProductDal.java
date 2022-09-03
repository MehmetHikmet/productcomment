package com.fttechnology.productcomment.DataAccess;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fttechnology.productcomment.Entities.Product;

public interface IProductDal extends JpaRepository<Product, Integer>{
	List<Product> findByExpireDateLessThan(LocalDate toDay);
	List<Product> findByExpireDateGreaterThan(LocalDate toDay);
}
