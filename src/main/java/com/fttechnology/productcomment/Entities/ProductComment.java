package com.fttechnology.productcomment.Entities;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name="comment")
@Table(name="comment")
@NamedQuery(name = "ProductComment.findByColumnCommentDateBetweenWithProductID",
query = "select u from comment u where u.productID=?1 and u.commentdate between ?2 and ?3")
@NamedQuery(name = "ProductComment.findByCommentDateBetweenWithUserID",
query = "select c from comment c where c.userID=?1 and c.commentdate between ?2 and ?3")
public class ProductComment {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="product_id")
	private int productID;
	
	@Column(name="user_id")
	private int userID;
	

	@Column(name="comment_date")
    @UpdateTimestamp
    private LocalDateTime commentdate;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;
	    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
    

	public ProductComment() {
		
	}


	public ProductComment(String comment, int productID, int userID) {
		this.comment = comment;
		this.productID = productID;
		this.userID = userID;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getCommentdate() {
		return commentdate;
	}

	public void setCommentdate(LocalDateTime commentdate) {
		this.commentdate = commentdate;
	}
	
	public int getProductID() {
		return productID;
	}



	public void setProductID(int productID) {
		this.productID = productID;
	}



	public int getUserID() {
		return userID;
	}



	public void setUserID(int userID) {
		this.userID = userID;
	}
	
}
