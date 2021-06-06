package com.xxx.server.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxx.server.wb.Menu;
import com.xxx.server.wb.People;
import com.xxx.server.wb.User;
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
public interface UserMapper extends BaseMapper<User> {
    /**
     * 获取所有hr(分页)
     * @param page
     * @param user
     * @param beginDateScope
     * @return
     */
    IPage<User> getUserByPage(Page<User> page, @Param("user") User user, @Param("beginDateScope") LocalDate[] beginDateScope);

}
