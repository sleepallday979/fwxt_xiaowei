package com.xxx.server.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxx.server.wb.Evaluate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxx.server.wb.User;
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
public interface EvaluateMapper extends BaseMapper<Evaluate> {
    /**
     * 获取所有评价(分页)
     * @param page
     * @param evaluate
     * @param beginDateScope
     * @return
     */
    IPage<Evaluate> getEvaByPage(Page<Evaluate> page, @Param("evaluate") Evaluate evaluate, @Param("beginDateScope") LocalDate[] beginDateScope);

    /**
     * 查询员工
     * @param id
     * @return
     */
    List<Evaluate> getEva(Integer id);
}
