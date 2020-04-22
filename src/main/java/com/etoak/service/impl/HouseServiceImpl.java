package com.etoak.service.impl;

import com.etoak.bean.Area;
import com.etoak.bean.House;
import com.etoak.bean.Page;
import com.etoak.bean.houseVo;
import com.etoak.mapper.AreaMapper;
import com.etoak.mapper.HouseMapper;

import com.etoak.service.HouseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wfqing on 2020/4/22.
 */
@Service
@Slf4j
public class HouseServiceImpl implements HouseService{
    @Autowired
    HouseMapper houseMapper;

    @Autowired
    AreaMapper areaMapper;
    @Override
    public int addHouse(House house) {
        Area area = areaMapper.queryById(house.getArea());
        if(area == null) {
            log.error("未查询到所在区， 查询所在去ID ______>{}", house.getArea());
            throw new RuntimeException("服务端异常");
        }
        house.setAreaName(area.getName());

        return houseMapper.addHouse(house);
    }

    @Override
    public Page<houseVo> queryList(int pageNum, int pageSize, houseVo houseV) {
        PageHelper.startPage(pageNum, pageSize);
        List<houseVo> houseVoList = houseMapper.queryList(houseV);
        PageInfo<houseVo> pageInfo = new PageInfo<>();
        return new Page<houseVo>(pageInfo.getPageNum(),
                pageInfo.getPageSize(),
                houseVoList,
                pageInfo.getTotal(),
                pageInfo.getPages());
    }
}
