package com.gec.system.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gec.model.system.SysCategory;
import com.gec.model.vo.SysCategoryQueryVo;

/**
* @author 14700
* @description 针对表【sys_category】的数据库操作Service
* @createDate 2024-09-26 16:22:07
*/
public interface SysCategoryService extends IService<SysCategory> {

    public IPage<SysCategory> selectPage(IPage<SysCategory> p1, SysCategoryQueryVo sysCategoryQueryVo);
}
