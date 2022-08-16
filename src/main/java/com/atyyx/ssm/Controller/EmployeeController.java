package com.atyyx.ssm.Controller;

import com.atyyx.ssm.Service.EmployeeService;
import com.atyyx.ssm.pojo.Emp;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.function.Consumer;

/**
 * 查询所有的员工信息
 */
@Controller
public class EmployeeController
{
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public String getAllEmps(Model model)
    {
        List<Emp> emps = employeeService.getAllEmps();
        model.addAttribute("emps",emps);

        emps.stream().forEach( s -> System.out.println(s));
        return "success";
    }


    @GetMapping("/employee/page/{pageNum}")
    public String getEmpsPage(@PathVariable("pageNum") Integer pageNum,Model model)
    {
        // 获取员工的分页信息
        PageInfo<Emp> page=employeeService.getEmpPage(pageNum);
        // 将分页数据共享到请求域中
        model.addAttribute("page",page);
        // 跳转到employee_list页面去
        return "employee_list";
    }

}
