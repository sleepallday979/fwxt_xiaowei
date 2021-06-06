package com.xxx.server.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxx.server.wb.People;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tsd
 * @since 2021-05-30
 */
public interface PeopleMapper extends BaseMapper<People> {

    /**
     * 获取所有员工(分页)
     * @param page
     * @param employee
     * @param beginDateScope
     * @return
     */
    IPage<People> getEmployeeByPage(Page<People> page, @Param("employee") People employee, @Param("beginDateScope") LocalDate[] beginDateScope);

    /**
     * 查询员工
     * @param name
     * @return
     */
    List<People> getEmployee(String name);
}
