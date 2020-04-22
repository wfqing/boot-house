package com.etoak.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by wfqing on 2020/4/20.
 */
@Data
public class Area implements Serializable {
    private Integer id;
    private Integer pid;
    private String name;
    private Integer sort;

}
