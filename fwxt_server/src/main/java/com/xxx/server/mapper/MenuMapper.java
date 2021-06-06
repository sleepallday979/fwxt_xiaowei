package com.xxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxx.server.wb.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tsd
 * @since 2021-06-03
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 通过用户id查询菜单列表
     * @param id
     * @return
     */
    List<Menu> getMenuByAdminId(Integer id);
}