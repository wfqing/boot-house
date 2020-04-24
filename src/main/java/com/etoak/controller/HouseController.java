package com.etoak.controller;

import com.etoak.bean.House;

import com.etoak.bean.Page;
import com.etoak.bean.houseVo;
import com.etoak.service.HouseService;
import com.etoak.utils.Validator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by wfqing on 2020/4/21.
 */
@Controller
@RequestMapping("/house")
@Slf4j

public class HouseController {
    //读取配置文件
    @Value("${upload.dir}")
    private String uploadDirectory;
    //获取图片访问路径前缀
    @Value("${upload.savePathPrefix}")
    private String savePathPrefix;

    @Autowired
    HouseService houseService;

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "/house/add";
    }


    @PostMapping("/add")
    public String add(@RequestParam("file")MultipartFile file, House house/*, BindingResult bingResult*/)
            throws IOException {
        Validator.validate(house);

        /*List<ObjectError> allErrors = bingResult.getAllErrors();

        if(CollectionUtils.isNotEmpty(allErrors)){
            StringBuffer buffer = new StringBuffer();
            for (ObjectError objectError:allErrors) {
                String defaultMessage = objectError.getDefaultMessage();
                buffer.append(defaultMessage).append(";");
            }
            throw new RuntimeException("参数检验失败" + buffer.toString());
        }*/
        //文件全名
        String originalFilename = file.getOriginalFilename();
        //String suffix = FilenameUtils.getExtension(originalFilename);

        String prefix = UUID.randomUUID().toString().replaceAll("-", "");
        String newFileName = prefix + "-" + originalFilename;
log.info("house___________rentmode   >", house.getRentMode());
        File destFile = new File(this.uploadDirectory, newFileName);
        file.transferTo(destFile);
        //给house设置访问地址
        house.setPic(this.savePathPrefix + newFileName);
        houseService.addHouse(house);

        return "redirect:/house/toAdd";
    }


    @GetMapping(value = "/list", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Page<houseVo> queryList(@RequestParam(required = false, defaultValue = "0") int pageNum,
                                   @RequestParam(required = false, defaultValue = "3") int pageSize,
                                   houseVo houseV,
                                   @RequestParam(value = "rentalList[]", required = false) String[] rentalList) {
log.info("111111111111111111,{}", rentalList);
        return houseService.queryList(pageNum, pageSize, houseV, rentalList);

    }
    @GetMapping("/toList")
    public String toList() {
        return "/house/list";

    }
    @PutMapping("/update")
    public String uodate(House house) {
        houseService.updateHouse(house);
        return "redirect:/house/toList";
    }


}
