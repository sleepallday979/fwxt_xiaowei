package com.xxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.wb.RespBean;
import com.xxx.server.wb.User;

import javax.servlet.http.HttpServletRequest;

/**
 * 服务类
 * @Author: tsd
 * @Date: 2021/6/1 20:17
 */
public interface IAdminService extends IService<User> {
    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @param request
     * @return
     */
    RespBean login(String username, String password, String code, HttpServletRequest request);

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    User getAdminByUserName(String username);


}
