package com.ibm.user.repository;

import com.ibm.user.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-10-31 23:26
 */
public interface UserRepository  extends CrudRepository<User, Long> {

    @Query("SELECT user FROM User user WHERE user.email= :email")
    User getUser(@Param("email") String email);


   // void createUser(User newuser);
}
