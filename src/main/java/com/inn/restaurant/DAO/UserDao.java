package com.inn.restaurant.DAO;

import com.inn.restaurant.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User,Integer> {
    //we will find user by email using http -->POJO
    User findByEmailId(@Param("email") String email);
}
