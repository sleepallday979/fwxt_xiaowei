package com.xxx.server.controller;

import com.xxx.server.service.IAdminService;
import com.xxx.server.wb.AdminLoginParam;
import com.xxx.server.wb.RespBean;
import com.xxx.server.wb.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * 登录
 * @Author: tsd
 * @Date: 2021/6/1 20:09
 */
@Api(tags = "LoginController")
@RestController
public class LoginController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    private RespBean login(AdminLoginParam adminLoginParam, HttpServletRequest request){
        return adminService.login(adminLoginParam.getUsername(),adminLoginParam.getPassword(),request);
    }


    @ApiOperation(value = "获取当前登录用户的信息")
    @GetMapping("/admin/info")
    public User getUserInfo(Principal principal){
        if(null == principal){
            return null;
        }
        String username = principal.getName();
        User user = adminService.getAdminByUserName(username);
        user.setPassword(null);
        return user;
    }


    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public RespBean logout(){
        return RespBean.success("注销成功！");
    }
}
