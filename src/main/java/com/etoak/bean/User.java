package com.etoak.bean;

import lombok.Data;

/**
 * Created by wfqing on 2020/4/20.
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private String gender;
    private Integer age;

    private String birthday;
    private String email;
    private Integer state;
}
