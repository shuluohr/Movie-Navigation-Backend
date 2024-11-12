package com.gec.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gec.model.system.SysLoginLog;
import com.gec.model.system.SysOperLog;
import com.gec.model.vo.SysOperLogQueryVo;
import com.gec.system.mapper.SysOperLogMapper;
import com.gec.system.service.SysOperLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
* @author 14700
* @description 针对表【sys_oper_log(操作日志记录)】的数据库操作Service实现
* @createDate 2024-09-27 18:22:36
*/
@Service
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog>
    implements SysOperLogService {


    @Resource
    private SysOperLogMapper sysOperLogMapper;


    @Override
    public void recordOperLog(SysOperLog sysOperLog) {
        this.sysOperLogMapper.insert(sysOperLog);
    }

    @Override
    public IPage<SysOperLog> selectPage(long page, long limit, SysOperLogQueryVo sysOperLogQueryVo) {
        //创建page对象
        IPage<SysOperLog> pageParam = new Page<SysOperLog>(page,limit);
        //获取条件值
        String username = sysOperLogQueryVo.getOperName();
        String title = sysOperLogQueryVo.getTitle();
        String createTimeBegin = sysOperLogQueryVo.getCreateTimeBegin();
        String createTimeEnd = sysOperLogQueryVo.getCreateTimeEnd();
        //封装条件
        QueryWrapper<SysOperLog> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(username)) {
            wrapper.like("username",username);
        }
        if(!StringUtils.isEmpty(title)) {
            wrapper.eq("title",title);
        }
        if(!StringUtils.isEmpty(createTimeBegin)) {
            wrapper.ge("create_time",createTimeBegin);
        }
        if(!StringUtils.isEmpty(createTimeBegin)) {
            wrapper.le("create_time",createTimeEnd);
        }
        //调用mapper方法
        IPage<SysOperLog> pageModel = sysOperLogMapper.selectPage(pageParam, wrapper);
        return pageModel;
    }

}




