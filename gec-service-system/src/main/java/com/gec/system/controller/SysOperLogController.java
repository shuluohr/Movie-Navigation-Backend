package com.gec.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gec.model.system.SysLoginLog;
import com.gec.model.system.SysOperLog;
import com.gec.model.vo.SysLoginLogQueryVo;
import com.gec.model.vo.SysOperLogQueryVo;
import com.gec.system.service.SysLoginLogService;
import com.gec.system.service.SysOperLogService;
import com.gec.system.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 陈君哲
 */
@Api(tags = "操作日志控制器")
@RestController
@RequestMapping("/admin/system/sysOperLog")
@Slf4j
public class SysOperLogController {

    @Resource
    private SysOperLogService sysOperLogService;

    @ApiOperation(value = "获取分页列表")
    @GetMapping("{page}/{limit}")
    public Result QueryLoginLog(
            @PathVariable Long page,
            @PathVariable Long limit,
            SysOperLogQueryVo sysOperLogQueryVo) {

        IPage<SysOperLog> iPage = sysOperLogService.selectPage(page, limit, sysOperLogQueryVo);
        return Result.ok(iPage);
    }

    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        SysOperLog sysOperLog = sysOperLogService.getById(id);
        return Result.ok(sysOperLogService);
    }

    @ApiOperation(value = "删除记录")
    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable Long id) {
        boolean result = sysOperLogService.removeById(id);
        System.out.println(result);
        return result?Result.ok():Result.fail();
    }
}
