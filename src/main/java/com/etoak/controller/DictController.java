package com.etoak.controller;

import com.etoak.bean.Dict;
import com.etoak.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wfqing on 2020/4/21.
 */
@RestController
@RequestMapping("/dict")
@Api(tags = "字典查询服务")
public class DictController {
    @Autowired
    DictService dictService;


    @ApiOperation(value = "根据groupId查询字典列表", notes = "查询字典列表")
    @ApiImplicitParam(value = "字典id", name = "groupId",required = true, paramType = "path")

    @GetMapping("/{groupId}")
    public List<Dict> queryList(@PathVariable("groupId") String groupId) {
        return dictService.queryList(groupId);
    }
}
