package com.gec.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gec.model.system.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_menu(菜单表)】的数据库操作Mapper
* @createDate 2024-09-23 14:11:44
* @Entity com.gec.system.system.SysMenu
*/
public interface SysMenuMapper extends BaseMapper<SysMenu> {


    List<SysMenu> findMenuListByUserId(@Param("userId") Long userId);

}




