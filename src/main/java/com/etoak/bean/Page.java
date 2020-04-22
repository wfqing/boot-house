package com.etoak.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by wfqing on 2020/4/22.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> {
    private int pageNum;
    private int pageSize;
    private List<T> rows;
    private long total;//总记录数
    private int pageCount;

}
