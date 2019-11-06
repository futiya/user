package com.ibm.user.service;

import com.ibm.user.dao.UserDao;
import com.ibm.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-10-31 21:46
 */
@Service
public class UserService {
    @Autowired
    private  UserDao dao;

    public User getUser(String email){
        return dao.getUser(email);
    }

    public void addUser(User newuser) {
        dao.createUser(newuser);
    }
}
