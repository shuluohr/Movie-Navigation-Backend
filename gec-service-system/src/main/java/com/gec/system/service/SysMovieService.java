package com.gec.system.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gec.model.system.SysMovie;
import com.gec.model.vo.SysMovieQueryVo;

/**
* @author 14700
* @description 针对表【sys_movie】的数据库操作Service
* @createDate 2024-09-27 08:48:31
*/
public interface SysMovieService extends IService<SysMovie> {
    IPage<SysMovie> selectPage(IPage<SysMovie> p1, SysMovieQueryVo sysMovieQueryVo);
}
