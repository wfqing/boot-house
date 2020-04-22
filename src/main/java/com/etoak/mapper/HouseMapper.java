package com.etoak.mapper;

import com.etoak.bean.House;
import com.etoak.bean.houseVo;

import java.util.List;

/**
 * Created by wfqing on 2020/4/22.
 */
public interface HouseMapper {
    int addHouse(House house);

    List<houseVo> queryList(houseVo houseV);
}
