package com.xxx.server.controller;


import com.xxx.server.service.IEvaluateService;
import com.xxx.server.service.IUserService;
import com.xxx.server.wb.Evaluate;
import com.xxx.server.wb.RespBean;
import com.xxx.server.wb.RespPageBean;
import com.xxx.server.wb.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tsd
 * @since 2021-05-30
 */
@RestController
@RequestMapping("/evaluate")
public class EvaluateController {
    @Autowired
    private IEvaluateService evaluateService;
    @ApiOperation(value = "获取所有hr(分页)")
    @GetMapping("/get")
    public RespPageBean getUser(@RequestParam(defaultValue = "1") Integer currentPage,
                                @RequestParam(defaultValue = "10") Integer size,
                                Evaluate evaluate,
                                LocalDate[] beginDateScope){
        return evaluateService.getEvaByPage(currentPage,size,evaluate,beginDateScope);
    }

    @ApiOperation(value = "添加hr")
    @PostMapping("/add")
    public RespBean addEva(@RequestBody Evaluate evaluate){
        return evaluateService.addEva(evaluate);
    }

    @ApiOperation(value = "更新hr")
    @PutMapping("/update")
    public RespBean updateUser(@RequestBody Evaluate evaluate){
        if (evaluateService.updateById(evaluate)){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "删除hr")
    @DeleteMapping("/{id}")
    public RespBean delEmp(@PathVariable Integer id){
        if (evaluateService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
