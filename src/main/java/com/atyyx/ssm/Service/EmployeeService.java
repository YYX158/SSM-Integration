package com.atyyx.ssm.Service;

import com.atyyx.ssm.pojo.Emp;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmployeeService {
    public List<Emp>  getAllEmps();

    /**
     * 获取员工的分页信息
     * @return
     */
    PageInfo<Emp> getEmpPage(Integer pageNum);
}
