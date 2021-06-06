package com.xxx.server.controller;


import com.xxx.server.service.IPeopleService;
import com.xxx.server.service.IUserService;
import com.xxx.server.wb.People;
import com.xxx.server.wb.RespBean;
import com.xxx.server.wb.RespPageBean;
import com.xxx.server.wb.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tsd
 * @since 2021-05-30
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @ApiOperation(value = "获取所有hr(分页)")
    @GetMapping("/get")
    public RespPageBean getUser(@RequestParam(defaultValue = "1") Integer currentPage,
                                    @RequestParam(defaultValue = "10") Integer size,
                                    User user,
                                    LocalDate[] beginDateScope){
        return userService.getUserByPage(currentPage,size,user,beginDateScope);
    }

    @ApiOperation(value = "添加hr")
    @PostMapping("/add")
    public RespBean addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @ApiOperation(value = "更新hr")
    @PutMapping("/update")
    public RespBean updateUser(@RequestBody User user){
        if (userService.updateById(user)){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "删除hr")
    @DeleteMapping("/{id}")
    public RespBean delEmp(@PathVariable Integer id){
        if (userService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
