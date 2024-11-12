package com.gec.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gec.model.system.SysMovie;
import com.gec.model.vo.SysMovieQueryVo;
import org.apache.ibatis.annotations.Param;

/**
* @author 14700
* @description 针对表【sys_movie】的数据库操作Mapper
* @createDate 2024-09-27 08:48:31
* @Entity generator.domain.SysMovie
*/
public interface SysMovieMapper extends BaseMapper<SysMovie> {

    public IPage<SysMovie> selectPage(IPage<SysMovie> p1, @Param("vo") SysMovieQueryVo sysMovieQueryVo);
}




