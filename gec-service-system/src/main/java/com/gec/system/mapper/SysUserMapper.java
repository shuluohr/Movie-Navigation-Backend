package com.gec.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gec.model.system.SysUser;
import com.gec.model.vo.SysUserQueryVo;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper extends BaseMapper<SysUser> {

    public IPage<SysUser> selectPage(IPage<SysUser> iPage, @Param("vo") SysUserQueryVo sysUserQueryVo);
}
