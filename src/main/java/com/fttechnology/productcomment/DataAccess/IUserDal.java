package com.fttechnology.productcomment.DataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fttechnology.productcomment.Entities.ProductComment;
import com.fttechnology.productcomment.Entities.User;

public interface IUserDal extends JpaRepository<User, Integer>{

}
