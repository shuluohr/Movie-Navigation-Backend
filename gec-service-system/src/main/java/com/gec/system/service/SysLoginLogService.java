package com.gec.system.service;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gec.model.system.SysLoginLog;
import com.gec.model.vo.SysLoginLogQueryVo;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
* @author 14700
* @description 针对表【sys_login_log(系统访问记录)】的数据库操作Service
* @createDate 2024-09-27 18:22:36
*/
public interface SysLoginLogService extends IService<SysLoginLog> {

    /**
     *
     * @param username
     * @param status
     * @param ipaddr
     * @param message
     */
    public void recordLoginLog(String username,Integer status,String ipaddr,String message);


    /**
     *
     * @param page
     * @param limit
     * @param sysLoginLogQueryVo
     * @return
     */
    //条件分页查询登录日志
    IPage<SysLoginLog> selectPage(long page, long limit, SysLoginLogQueryVo sysLoginLogQueryVo);


    SysLoginLog getById(Long id);
}
