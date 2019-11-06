package com.ibm.user.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-10-31 23:02
 */
@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String email;

    private String password;

    @CreatedDate
    private Date createTime;

    private String firstName;

    private String lastName;

    private String contactNumber;

    private Boolean active;

    private String role;
}
