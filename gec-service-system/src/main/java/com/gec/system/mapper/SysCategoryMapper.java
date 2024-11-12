package com.gec.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gec.model.system.SysCategory;
import com.gec.model.vo.SysCategoryQueryVo;
import org.apache.ibatis.annotations.Param;

/**
* @author 14700
* @description 针对表【sys_category】的数据库操作Mapper
* @createDate 2024-09-26 16:22:07
* @Entity generator.domain.SysCategory
*/
public interface SysCategoryMapper extends BaseMapper<SysCategory> {

    IPage<SysCategory> selectPage(IPage<SysCategory> p1, @Param("vo") SysCategoryQueryVo sysCategoryQueryVo);
}




