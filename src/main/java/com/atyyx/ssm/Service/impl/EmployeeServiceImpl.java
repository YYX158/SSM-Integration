package com.atyyx.ssm.Service.impl;

import com.atyyx.ssm.Service.EmployeeService;
import com.atyyx.ssm.mapper.EmpMapper;
import com.atyyx.ssm.pojo.Emp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    EmpMapper empMapper;
    public List<Emp> getAllEmps()
    {
        List<Emp> emps = empMapper.getAllEmps();
        return emps;
    }

    @Override
    public PageInfo<Emp> getEmpPage(Integer pageNum)
    {
        //开启分页功能
        // 本身就是个拦截器，直接往这个sql里面加入limit
        PageHelper.startPage(pageNum,4);// 一般情况下每页显示的条数是固定的
        // 查询所有的员工信息
        List<Emp> emps = empMapper.getAllEmps();
        // 获取分页相关数据,第二个参数就是导航分页功能
        PageInfo<Emp> page = new PageInfo<>(emps,5);
        return page;
    }
}
