package com.xxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.wb.Evaluate;
import com.xxx.server.wb.RespBean;
import com.xxx.server.wb.RespPageBean;
import com.xxx.server.wb.User;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tsd
 * @since 2021-05-30
 */
public interface IEvaluateService extends IService<Evaluate> {
    /**
     * 获取评价(分页)
     * @param currentPage
     * @param size
     * @param evaluate
     * @param beginDateScope
     * @return
     */
    RespPageBean getEvaByPage(Integer currentPage, Integer size, Evaluate evaluate, LocalDate[] beginDateScope);
    /**
     * 添加评价
     * @param evaluate
     * @return
     */
    RespBean addEva(Evaluate evaluate);

    /**
     * 查询员工
     * @param id
     * @return
     */
    List<Evaluate> getEva(Integer id);
}
