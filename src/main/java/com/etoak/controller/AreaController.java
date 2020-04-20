package com.etoak.controller;

import com.etoak.bean.Area;
import com.etoak.service.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wfqing on 2020/4/20.
 */
@RestController
@Slf4j
@RequestMapping("/area")
@Api(tags = "地区查询服务")
public class AreaController {
    @Autowired
    AreaService areaService;

    @GetMapping("/queryById")
    @ApiOperation(value = "根据父id查询地区列表", notes = "根据父id查询地区列表")
    @ApiImplicitParam(value = "父id", name = "pid", required = false, defaultValue = "0", dataType = "int")
    public List<Area> queryById(@RequestParam(required = false, defaultValue = "0") int pid){
        return areaService.queryByPid(pid);
    }
}
