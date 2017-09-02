package com.carlos.core.controller;

import com.carlos.core.dao.DepartmentDao;
import com.carlos.core.dao.EmployeeDao;
import com.carlos.core.entity.Department;
import com.carlos.core.entity.Employee;
import com.carlos.core.entity.ViewObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/26 0026.
 */
//@RequestMapping("/test")
@Controller
public class EmployeeHandler {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    private List<ViewObject> getEmployees(){
        List<ViewObject> vos = new ArrayList<ViewObject>();
        for (Employee employee : employeeDao.getAll()) {
            ViewObject vo = new ViewObject();
            vo.set("employee", employee);
            vos.add(vo);
        }
        return vos;
    }

    private List<ViewObject> getDepartments(){
        List<ViewObject> vos = new ArrayList<ViewObject>();
        for (Department department : departmentDao.getDepartments()) {
            ViewObject vo = new ViewObject();
            vo.set("department", department);
            vos.add(vo);
        }
        return vos;
    }
    @RequestMapping("/emps")
    public String list(Model model,Map<String, Object> map){
        model.addAttribute("vos",getEmployees());
        map.put("employees", employeeDao.getAll());
        return "test";
    }
    @RequestMapping("/emp")
    public String input(Model model){
        Map<String, String> genders = new HashMap<String, String>();
        genders.put("1", "male");
        genders.put("0", "female");
        model.addAttribute("gender",genders);
        model.addAttribute("vos",getDepartments());
        return "input";
    }

    @RequestMapping(value="/emp", method= RequestMethod.POST)
    public String save(String lastName,String email,String gender,String departmentName){
        System.out.println("data return success。。。");
        System.out.println(gender);
        System.out.println(departmentName);
        Employee employee=new Employee();
        employee.setLastName(lastName);
        employee.setGender(Integer.parseInt(gender));
        employee.setEmail(email);
        employee.setDepartment(departmentDao.getDepartment(Integer.parseInt(departmentName)));
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        System.out.println(id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public String input(@PathVariable("id") Integer id,Model model){
        Map<String, String> genders = new HashMap<String, String>();
        genders.put("1", "male");
        genders.put("0", "female");
        model.addAttribute("gender",genders);
        model.addAttribute("employee",employeeDao.get(id));
        model.addAttribute("vos",getDepartments());
        return "input";
    }

    @RequestMapping(value="/emp", method=RequestMethod.PUT)
    public String update(String id,String lastName,String email,String gender,String departmentName){
        //StringBuilder sb=new StringBuilder("id:");
        //sb.append(id+"lastName:"+lastName+"email:"+email+"gender:"+gender+"departmentName:"+departmentName);
        Employee employee=employeeDao.get(Integer.parseInt(id));
        employee.setLastName(lastName);
        employee.setGender(Integer.parseInt(gender));
        employee.setEmail(email);
        employee.setDepartment(departmentDao.getDepartment(Integer.parseInt(departmentName)));
        employeeDao.save(employee);
        return "redirect:/emps";
        //return sb.toString();
    }

}
