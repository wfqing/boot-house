package com.etoak.mapper;

import com.etoak.bean.Dict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wfqing on 2020/4/21.
 */
public interface DictMapper {
    List<Dict> queryList(@Param("groupId") String groupId);

}
