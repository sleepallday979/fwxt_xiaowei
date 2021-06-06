package com.xxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.wb.Menu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tsd
 * @since 2021-06-03
 */
public interface IMenuService extends IService<Menu> {
    /**
     * 通过用户id查询菜单列表
     * @return
     */
    List<Menu> getMenuByAdminId();

}