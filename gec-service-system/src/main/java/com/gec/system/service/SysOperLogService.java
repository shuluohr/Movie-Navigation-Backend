package com.gec.system.service;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gec.model.system.SysOperLog;
import com.gec.model.vo.SysOperLogQueryVo;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
* @author 14700
* @description 针对表【sys_oper_log(操作日志记录)】的数据库操作Service
* @createDate 2024-09-27 18:22:36
*/
public interface SysOperLogService extends IService<SysOperLog> {


//    public void recordOperLog(String title, String businessType,
//                              String method, String requestMethod, String operatorType,
//                              String operUrl, String operIp, String operName,
//                              Integer status, String operParam, String jsonResult,
//                              String errorMsg, Date operTime);



    public void recordOperLog(SysOperLog sysOperLog);


    IPage<SysOperLog> selectPage(long page, long limit, SysOperLogQueryVo sysOperLogQueryVo);
}
