package com.etoak.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by wfqing on 2020/4/22.
 */
@Data
public class houseVo extends House{
    private String rentModeName;

    private String houseTypeName;

    private String orientationName;

    @JsonIgnore
    private String[] houseTypeList;
    @JsonIgnore
    private List<String> orientationList;

    private List<Map<String, Integer>> rentalMapList;


}
