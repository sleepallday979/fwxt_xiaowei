package com.xxx.server.controller;


import com.xxx.server.service.IPeopleService;
import com.xxx.server.wb.People;
import com.xxx.server.wb.RespBean;
import com.xxx.server.wb.RespPageBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
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
@RequestMapping("/employee/basic")
public class PeopleController {
    @Autowired
    private IPeopleService peopleService;
    @ApiOperation(value = "获取所有员工(分页)")
    @GetMapping("/get")
    public RespPageBean getEmployee(@RequestParam(defaultValue = "1") Integer currentPage,
                                    @RequestParam(defaultValue = "10") Integer size,
                                    People employee,
                                    LocalDate[] beginDateScope){
        return peopleService.getEmployeeByPage(currentPage,size,employee,beginDateScope);
    }

    @ApiOperation(value = "搜索单个员工")
    @GetMapping("/getname")
    public List<People> getEmployeeother(String name){
        return peopleService.getEmployeeother(name);
    }


    @ApiOperation(value = "添加员工")
    @PostMapping("/add")
    public RespBean addEmp(@RequestBody People employee){
        return peopleService.addEmp(employee);
    }

    @ApiOperation(value = "更新员工")
    @PutMapping("/update")
    public RespBean updateEmp(@RequestBody People employee){
        if (peopleService.updateById(employee)){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "删除员工")
    @DeleteMapping("/{id}")
    public RespBean delEmp(@PathVariable Integer id){
        if (peopleService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

}
