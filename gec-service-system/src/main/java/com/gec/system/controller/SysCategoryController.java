package com.gec.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gec.model.system.SysCategory;
import com.gec.model.vo.SysCategoryQueryVo;
import com.gec.system.service.SysCategoryService;
import com.gec.system.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//import com.gec.system.common.Result;

@RestController
@Api(tags = "影视分类")
@RequestMapping("/admin/system/sysCategory")
public class SysCategoryController {

    @Resource
    private SysCategoryService sysCategoryService;

    @ApiOperation("获取全部分类")
    @GetMapping("/findAll")
    public Result findAll(){
        List<SysCategory> list = this.sysCategoryService.list();
        return Result.ok(list);
    }
    // http://localhost:8085/admin/system/sysRole/removeRole/14
    @ApiOperation("根据id去移除一个分类")
    // 测试删除
    @DeleteMapping("/removeCategory/{id}")
    public Result removeCategory(@PathVariable Long id)
    {
        boolean b = this.sysCategoryService.removeById(id);
        if (b)
        {
            return Result.ok();
        }
        else
        {
            return Result.fail();
        }
    }

    // 分页和条件查询
    @ApiOperation("分页和条件查询")
    @GetMapping("/{page}/{limit}")
    public Result findCategoryByPageQuery(@PathVariable Long page,
                                          @PathVariable Long limit,
                                          SysCategoryQueryVo sysCategoryQueryVo)
    {
        //1.创建分页对象
        IPage<SysCategory> p1 = new Page<SysCategory>(page,limit);
        //2.调用方法
        p1 =  this.sysCategoryService.selectPage(p1,sysCategoryQueryVo);
        //3.返回
        return Result.ok(p1);
    }
    // 添加分类
    @ApiOperation("添加分类")
    @PostMapping("/addCategory")
    public Result addCategory(@RequestBody SysCategory sysCategory)
    {
        boolean res = this.sysCategoryService.save(sysCategory);
        if (res)
        {
            return Result.ok();
        }
        else
        {
            return Result.fail();
        }
    }
    // 修改
    //1.根据id 去得到当前分类
    @ApiOperation("根据id 去得到当前分类")
    @GetMapping("/findCategoryById/{id}")
    public Result findCategoryById(@PathVariable Long id)
    {
        SysCategory sysCategory = this.sysCategoryService.getById(id);
        return Result.ok(sysCategory);
    }
    // 实现修改
    @ApiOperation("实现修改")
    @PostMapping("/updateCategory")
    public Result updateCategory(@RequestBody SysCategory sysCategory)
    {
        boolean b = this.sysCategoryService.updateById(sysCategory);
        if (b)
        {
            return Result.ok();
        }
        else
        {
            return Result.fail();
        }
    }
    // 批量删除
    @ApiOperation("批量删除")
    @DeleteMapping("/removeCategoryByIds")
    public Result removeCategoryByIds(@RequestBody List<Long> ids)
    {
        boolean b = this.sysCategoryService.removeByIds(ids);
        if (b)
        {
            return Result.ok();
        }
        else
        {
            return Result.fail();
        }
    }
}