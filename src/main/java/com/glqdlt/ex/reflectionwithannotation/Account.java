package com.glqdlt.ex.reflectionwithannotation;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author glqdlt
 * 2019-02-19
 */
@Data
public class Account {

    private Long seq;
    private String name;
    private String id;
    private String password;
    private String email;

    private UserType userType;

    private Boolean enable;

    private Date regDate;

    private List<UserRole> roles;

}
