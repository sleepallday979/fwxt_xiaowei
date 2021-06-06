package com.xxx.server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxx.server.mapper.PeopleMapper;
import com.xxx.server.wb.People;
import com.xxx.server.wb.RespBean;
import com.xxx.server.wb.RespPageBean;
import com.xxx.server.wb.User;
import com.xxx.server.mapper.UserMapper;
import com.xxx.server.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tsd
 * @since 2021-05-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public RespPageBean getUserByPage(Integer currentPage, Integer size, User user, LocalDate[] beginDateScope) {
        // 开启分页
        Page<User> page = new Page<>(currentPage,size);
        IPage<User> userByPage = userMapper.getUserByPage(page, user, beginDateScope);
        RespPageBean respPageBean = new RespPageBean(userByPage.getTotal(),userByPage.getRecords());
        return respPageBean;
    }
    @Override
    public RespBean addUser(User user) {
        if (1 == userMapper.insert(user)){
//            People emp = peopleMapper.getEmployee(String.valueOf(employee.getId())).get(0);
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }
}
