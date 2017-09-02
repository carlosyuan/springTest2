package com.carlos.core.controller;

import com.carlos.core.dao.EmployeeDao;
import com.carlos.core.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

/**
 * Created by Administrator on 2017/8/22 0022.
 */
@Controller
public class TestController {
    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping(value = "/velocity", method = RequestMethod.GET)
    public String getTest(Model model) {
        model.addAttribute("hello", "test velocity");
        return "test";
    }
    @ResponseBody
    @RequestMapping("testJson")
    public Collection<Employee> testJson(){
        return employeeDao.getAll();
    }

    @RequestMapping("fileuploadpage")
    public String fileUpload(){
        return "fileupload";
    }

    @RequestMapping("testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        byte[] body = null;
        ServletContext servletContext = session.getServletContext();
        InputStream in = servletContext.getResourceAsStream("/files/aaa.txt");
        body = new byte[in.available()];
        in.read(body);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=aaa.txt");
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
        return response;
    }

}
