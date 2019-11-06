package com.ibm.user.controller;

import com.ibm.user.model.RspModel;
import com.ibm.user.model.User;
import com.ibm.user.service.UserService;
import com.ibm.user.utils.EncrytedPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-10-31 13:41
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    @ResponseBody
    public ResponseEntity<RspModel> hello(@PathVariable String name){

        RspModel rsp = new RspModel();
        rsp.setCode(200);
        rsp.setMessage("Ok");
        rsp.setData("hello");
        return new ResponseEntity<RspModel>(rsp, HttpStatus.OK);
    }

    @GetMapping("/getUser")
    @ResponseBody
    public ResponseEntity<RspModel> getUser( @RequestParam String email){
        try {
            User user = service.getUser(email);
           if (user != null) {
                RspModel rsp = new RspModel();
                rsp.setCode(200);
                rsp.setMessage("Ok");
                rsp.setData(user);
                return new ResponseEntity<RspModel>(rsp, HttpStatus.OK);

            } else {
                RspModel rsp = new RspModel();
                rsp.setCode(404);
                rsp.setMessage("Account No Found");
                return new ResponseEntity<RspModel>(rsp, HttpStatus.NOT_FOUND);
            }


        } catch (Exception ex) {
            RspModel rsp = new RspModel();
            rsp.setCode(500);
            rsp.setMessage(ex.getMessage());
            return new ResponseEntity<RspModel>(rsp, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @RequestMapping(value="/create",method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity<RspModel> createUser(@RequestBody User user){
        User u = service.getUser(user.getEmail());
        if (u != null) {
            RspModel rsp = new RspModel();
            rsp.setCode(202);
            rsp.setMessage("Account Exist");
            return new ResponseEntity<RspModel>(rsp, HttpStatus.OK);
        } else {
            User newuser = new User();
            String encrytedpassword = EncrytedPasswordUtils.encrytePassword(user.getPassword());
            newuser.setPassword(encrytedpassword);
            newuser.setUsername(user.getUsername());
            newuser.setEmail(user.getUsername());
            newuser.setRole(user.getRole());
            if (user.getRole().equals("user")) {
                newuser.setActive(true);
            }else {
                newuser.setActive(false);
            }
            service.addUser(newuser);

            RspModel rsp = new RspModel();
            rsp.setCode(200);
            rsp.setMessage("Account Created");
            return new ResponseEntity<RspModel>(rsp, HttpStatus.CREATED);
        }

    }

}
