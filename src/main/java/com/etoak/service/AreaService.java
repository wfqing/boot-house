package com.etoak.service;

import com.etoak.bean.Area;

import java.util.List;

/**
 * Created by wfqing on 2020/4/20.
 */
public interface AreaService {
    List<Area> queryByPid(int pid);
}
