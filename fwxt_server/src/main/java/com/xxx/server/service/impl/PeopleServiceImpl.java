package com.xxx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxx.server.wb.People;
import com.xxx.server.mapper.PeopleMapper;
import com.xxx.server.service.IPeopleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.server.wb.RespBean;
import com.xxx.server.wb.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tsd
 * @since 2021-05-30
 */
@Service
public class PeopleServiceImpl extends ServiceImpl<PeopleMapper, People> implements IPeopleService {

    @Autowired
    private PeopleMapper peopleMapper;

    @Override
    public RespPageBean getEmployeeByPage(Integer currentPage, Integer size, People employee, LocalDate[] beginDateScope) {
        // 开启分页
        Page<People> page = new Page<>(currentPage,size);
        IPage<People> employeeByPage = peopleMapper.getEmployeeByPage(page, employee, beginDateScope);
        RespPageBean respPageBean = new RespPageBean(employeeByPage.getTotal(),employeeByPage.getRecords());
        return respPageBean;
    }

    /**
     * 查询员工
     * @param name
     * @return
     */
    @Override
    public List<People> getEmployeeother(String name) {
        return peopleMapper.getEmployee(name);
    }

    @Override
    public RespBean addEmp(People employee) {
        if (1 == peopleMapper.insert(employee)){
//            People emp = peopleMapper.getEmployee(String.valueOf(employee.getId())).get(0);
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }
}
