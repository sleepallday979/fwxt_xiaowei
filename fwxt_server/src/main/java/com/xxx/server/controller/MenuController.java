package com.xxx.server.controller;


import com.xxx.server.service.IMenuService;
import com.xxx.server.wb.Menu;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tsd
 * @since 2021-06-03
 */
@RestController
@RequestMapping("/system/cfg")
public class MenuController {
    @Resource
    private IMenuService menuService;

    @ApiOperation(value = "通过用户id查询菜单列表")
    @GetMapping("/menu")
    public List<Menu> getMenuByAdminId(){
        return menuService.getMenuByAdminId();
    }
}
