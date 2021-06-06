package com.xxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.server.mapper.MenuMapper;
import com.xxx.server.service.IMenuService;
import com.xxx.server.wb.Menu;
import com.xxx.server.wb.User;
import io.jsonwebtoken.lang.Collections;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tsd
 * @since 2021-06-03
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper,Menu> implements IMenuService {
    @Resource
    private MenuMapper menuMapper;
    @Resource
    private RedisTemplate redisTemplate;
    /**
     * 通过用户id查询菜单列表
     * @return
     */
    @Override
    public List<Menu> getMenuByAdminId() {
        //拿到security上下文中当前登录的用户信息
        Integer principalId = ((User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal()).getId();
        //数据存入redis
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        //从redis获取菜单数据
        List<Menu> menus = (List<Menu>) operations.get("menu_" + principalId);
        //如果集合的数据为空，则去数据库查询
        if(Collections.isEmpty(menus)){
            menus = super.baseMapper.getMenuByAdminId(principalId);
            //将数据存入redis
            operations.set("menu_" + principalId,menus);
        }
        //根据用户id查询该用户对应的菜单列表
        return menus;
    }
}
