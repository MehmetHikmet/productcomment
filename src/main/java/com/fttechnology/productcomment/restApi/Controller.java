package com.fttechnology.productcomment.restApi;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fttechnology.productcomment.Entities.Product;
import com.fttechnology.productcomment.Entities.ProductComment;
import com.fttechnology.productcomment.Entities.User;
import com.fttechnology.productcomment.Service.IProductCommentService;

@RestController
@RequestMapping("/api")
public class Controller {

	
	@Autowired
	private IProductCommentService commentService;
	
	@PostMapping("/addComment")
	public void saveComment(@RequestBody ProductComment productComment) {
	 
		commentService.save(productComment);
		
	}
	@PostMapping("/addProduct")
	public void saveProduct(@RequestBody Product product) {
	 
		commentService.saveProduct(product);
		
	}
	
	@PostMapping("/addUser")
	public void saveUser(@RequestBody User user) {
	 
		commentService.saveUser(user);
		
	}
	
	@GetMapping("/commentsByUserID")
	public List<ProductComment> getCommentByUserId(@RequestParam(value="id") int id){
		
		return commentService.findAllByUserId(id);
	}
	
	@GetMapping("/commentsByProductID")
	public List<ProductComment> getCommentByProductId(@RequestParam(value="id") int id){
		
		return commentService.findAllByProductId(id);
	}
	
	@GetMapping("/commentsSpecificProductByDate")
	public List<ProductComment> getByDateWithProductId(@RequestParam(value="productID") int product_id,@RequestParam(value="startDate") String startDate, @RequestParam(value="endDate") String endDate){
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime start = LocalDateTime.parse(startDate, formatter);
		LocalDateTime end = LocalDateTime.parse(endDate, formatter);
		return commentService.findByCommentDateBetweenWithUserID(product_id,start,end);
	}
	
	@GetMapping("/commentsFromSpecificUserByDate")
	public List<ProductComment> getByUserCommentsBetweenDates(@RequestParam(value="userID") int id, @RequestParam(value="startDate") String startDate, @RequestParam(value="endDate") String endDate){
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime start = LocalDateTime.parse(startDate, formatter);
		LocalDateTime end = LocalDateTime.parse(endDate, formatter);
		return commentService.findByCommentDateBetweenWithUserID(id, start, end);
	}
	
	@GetMapping("/checkExpiredProducts")
	public List<Product> getExpiredProducts(){
		LocalDate toDay = LocalDate.now(ZoneId.of("GMT+03"));

		return commentService.findByExpireDateLessThan(toDay);
	}
	
	
	@GetMapping("/checkExpireProducts")
	public List<Product> getExpireProducts(){
		LocalDate toDay = LocalDate.now(ZoneId.of("GMT+03"));

		return commentService.findByExpireDateGreaterThan(toDay);
	}
	
	@PutMapping("/updateComment")  
	private ProductComment updateComment(@RequestBody ProductComment comment)   
	{  
	commentService.saveOrUpdate(comment);  
	return comment;  
	} 
	
	@DeleteMapping("/comment/delete/{id}")
	public String deleteCommentById(@PathVariable("id")
    int commentId) {
		commentService.deleteById(commentId);
		return "Deleted succesfully";
	}
	
	
}
