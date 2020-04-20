package com.etoak.controller;

import com.etoak.bean.Area;
import com.etoak.service.AreaService;
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
public class AreaController {
    @Autowired
    AreaService areaService;

    @GetMapping("/queryById")
    public List<Area> queryById(@RequestParam(required = false, defaultValue = "0") int pid){
        return areaService.queryByPid(pid);
    }
}
