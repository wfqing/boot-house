package com.etoak.service;

import com.etoak.bean.House;
import com.etoak.bean.Page;
import com.etoak.bean.houseVo;

/**
 * Created by wfqing on 2020/4/22.
 */

public interface HouseService {
    int addHouse(House house);
    Page<houseVo> queryList(int pageNum, int pageSize, houseVo houseV,String[] rentalList);

    int updateHouse(House house);

    int  deleteById(int id);
}
