package com.gec.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gec.exception.MyCustomerException;
import com.gec.model.system.SysRole;
import com.gec.model.vo.AssginRoleVo;
import com.gec.system.service.SysRoleService;

import com.gec.system.util.Result;
import com.gec.model.vo.SysRoleQueryVo;
import com.gec.system.util.ResultCodeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "角色管理控制器")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    // http://localhost:8080/admin/system/sysRole/findAll

    // http://localhost:8080/admin/system/sysRole/findAll

    @ApiOperation("查询全部接口")
    @GetMapping("/findAll")
    public Result findAll() throws ClassNotFoundException {

        List<SysRole> list = this.sysRoleService.list();
        return Result.ok(list);
    }

    // 根据 id 去逻辑删除
    @PreAuthorize("hasAuthority('bnt.sysRole.remove')")
    @ApiOperation("逻辑删除接口")
    @DeleteMapping("/remove/{id}")
    public Result removeRole(@PathVariable Long id) {
        boolean isSuccess = this.sysRoleService.removeById(id);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    // 分页 + 查询
    @PreAuthorize("hasAuthority('bnt.sysRole.list')")
    @ApiOperation("角色分页查询")
    @GetMapping("/{page}/{limit}")
    public Result findRoleByPageQuery(@PathVariable("page") Long pageIndex,
                                      @PathVariable("limit") Long pageSize,
                                      SysRoleQueryVo roleQueryVo) {
        IPage<SysRole> page1 = new Page<>(pageIndex, pageSize);
        page1 = this.sysRoleService.selectPage(page1, roleQueryVo);
        return Result.ok(page1);
    }

    // 添加
    @PreAuthorize("hasAuthority('bnt.sysRole.add')")
    @ApiOperation("添加角色")
    @PostMapping("addRole")
    public Result addRole(@RequestBody SysRole sysRole) {
        boolean isSuccess = this.sysRoleService.save(sysRole);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    // 根据id 去获取一个role
    @PreAuthorize("hasAuthority('bnt.sysRole.list')")
    @GetMapping("findRoleById/{id}")
    @ApiOperation("根据id查询")
    public Result findRoleById(@PathVariable Long id) {
        SysRole sysRole = this.sysRoleService.getById(id);
        return Result.ok(sysRole);
    }


    // 修改
    @PreAuthorize("hasAuthority('bnt.sysRole.update')")
    @ApiOperation("修改角色")
    @PostMapping("updateRole")
    public Result updateRole(@RequestBody SysRole sysRole) {
        boolean isSuccess = this.sysRoleService.updateById(sysRole);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    // 批量删除
    @PreAuthorize("hasAuthority('bnt.sysRole.remove')")
    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> ids) {
        boolean isSuccess = this.sysRoleService.removeByIds(ids);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation(value = "根据用户获取角色数据")
    @GetMapping("/toAssign/{userId}")
    public Result toAssign(@PathVariable Long userId) {
        Map<String, Object> roleMap = sysRoleService.getRolesByUserId(userId);
        return Result.ok(roleMap);
    }

    @ApiOperation(value = "根据用户分配角色")
    @PostMapping("/doAssign")
    public Result doAssign(@RequestBody AssginRoleVo assginRoleVo) {
        sysRoleService.doAssign(assginRoleVo);
        return Result.ok();
    }
}
