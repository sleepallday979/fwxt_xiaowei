package com.xxx.server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxx.server.mapper.UserMapper;
import com.xxx.server.wb.Evaluate;
import com.xxx.server.mapper.EvaluateMapper;
import com.xxx.server.service.IEvaluateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.server.wb.RespBean;
import com.xxx.server.wb.RespPageBean;
import com.xxx.server.wb.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tsd
 * @since 2021-05-30
 */
@Service
public class EvaluateServiceImpl extends ServiceImpl<EvaluateMapper, Evaluate> implements IEvaluateService {
    @Resource
    private EvaluateMapper evaluateMapper;

    @Override
    public RespPageBean getEvaByPage(Integer currentPage, Integer size, Evaluate evaluate, LocalDate[] beginDateScope) {
        // 开启分页
        Page<Evaluate> page = new Page<>(currentPage,size);
        IPage<Evaluate> evaByPage = evaluateMapper.getEvaByPage(page, evaluate, beginDateScope);
        RespPageBean respPageBean = new RespPageBean(evaByPage.getTotal(),evaByPage.getRecords());
        return respPageBean;
    }
    @Override
    public RespBean addEva(Evaluate evaluate) {
        if (1 == evaluateMapper.insert(evaluate)){
//            People emp = peopleMapper.getEmployee(String.valueOf(employee.getId())).get(0);
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }
    /**
     * 查询员工
     * @param id
     * @return
     */
    @Override
    public List<Evaluate> getEva(Integer id) {
        return evaluateMapper.getEva(id);
    }
}
