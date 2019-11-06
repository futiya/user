package com.ibm.user.dao;

import com.ibm.user.model.User;
import com.ibm.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-10-31 23:36
 */
@Component
public class UserDao {
    @Autowired
    private UserRepository repository;

    public User getUser(String email){
        User user = null;
        user = repository.getUser(email);
        return user;
    }

    public void createUser(User newuser) {
        repository.save(newuser);
    }
}
