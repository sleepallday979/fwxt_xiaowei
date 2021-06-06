package com.xxx.server.service;

import com.xxx.server.wb.People;
import com.xxx.server.wb.RespBean;
import com.xxx.server.wb.RespPageBean;
import com.xxx.server.wb.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tsd
 * @since 2021-05-30
 */
public interface IUserService extends IService<User> {
    /**
     * 获取所有员工(分页)
     * @param currentPage
     * @param size
     * @param user
     * @param beginDateScope
     * @return
     */
    RespPageBean getUserByPage(Integer currentPage, Integer size, User user, LocalDate[] beginDateScope);
    /**
     * 添加员工
     * @param user
     * @return
     */
    RespBean addUser(User user);
}
