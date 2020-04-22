package com.etoak.bean;

import javafx.beans.NamedArg;
import lombok.Data;
import org.springframework.context.annotation.Bean;

import javax.validation.constraints.*;

/**
 * Created by wfqing on 2020/4/22.
 */
@Data
public class House {
    private Integer id;
    @NotNull(message = "省必填")

    private Integer province;
    @NotNull(message = "市必填")
    private Integer city;
    @NotNull(message = "区县必填")
    private Integer area;
    //所在县区名称
    private String areaName;
    //租赁方式
    @NotNull(message = "租赁方式不能为空")
    @NotBlank(message = "租赁方式不蹦为空！！！！！！！！")
    private String rentMode;

    private String orientation;

    private String houseType;
    @NotNull(message = "租金不能为空")
    @Max(value = 100000, message = "资金不能超过10万")
    @Min(value = 100, message = "租金不能低于100")
    private Integer rental;
@Size(min = 1, max = 10, message = "地址在10个字符以内")
    private String address;

    private String pic;

    private String publishTime;


}
