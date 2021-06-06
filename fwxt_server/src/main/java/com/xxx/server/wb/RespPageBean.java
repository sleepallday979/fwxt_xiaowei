package com.xxx.server.wb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: tsd
 * @Date: 2021/6/6 13:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespPageBean {
    /**
     * 总条数
     */
    private Long total;
    /**
     * 数据
     */
    private List<?> data;
}
