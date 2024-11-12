package com.gec.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gec.model.system.SysUser;
import com.gec.model.vo.RouterVo;
import com.gec.model.vo.SysUserQueryVo;
import com.gec.system.mapper.SysUserMapper;
import com.gec.system.service.SysMenuService;
import com.gec.system.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysMenuService sysMenuService;

    @Override
    public IPage<SysUser> selectPage(IPage<SysUser> iPage, SysUserQueryVo sysUserQueryVo) {
       return this.baseMapper.selectPage(iPage,sysUserQueryVo);
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        //1.查询出当前用户
        SysUser sysUser = this.baseMapper.selectById(id);
        //2.设置状态
        sysUser.setStatus(status);
        //3.更新
        this.baseMapper.updateById(sysUser);
    }

    @Override
    public SysUser getUserInfoUserName(String username) {

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>();
        queryWrapper.eq("username",username);

        SysUser sysUser = this.baseMapper.selectOne(queryWrapper);

        return sysUser;
    }

    @Override
    public Map<String, Object> getUserInfo(String username) {
        Map<String, Object> map = new HashMap<>();
        SysUser sysUser = this.getUserInfoUserName(username);

        //根据用户id获取菜单权限值
        List<RouterVo> routerVoList = sysMenuService.findUserMenuList(sysUser.getId());
        //根据用户id获取用户按钮权限
        List<String> permsList = sysMenuService.findUserPermsList(sysUser.getId());

        //当前权限控制使用不到，我们暂时忽略
        map.put("name", sysUser.getName());
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("roles",  "[admin]");


        map.put("buttons", permsList);
        map.put("routers", routerVoList);
        return map;
    }
}