package com.xxx.server.service;

import com.xxx.server.wb.People;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.wb.RespBean;
import com.xxx.server.wb.RespPageBean;

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
public interface IPeopleService extends IService<People> {
    /**
     * 获取所有员工(分页)
     * @param currentPage
     * @param size
     * @param employee
     * @param beginDateScope
     * @return
     */
    RespPageBean getEmployeeByPage(Integer currentPage, Integer size, People employee, LocalDate[] beginDateScope);

    /**
     * 查询员工
     * @param name
     * @return
     */
    List<People> getEmployeeother(String name);
    /**
     * 添加员工
     * @param employee
     * @return
     */
    RespBean addEmp(People employee);
}

