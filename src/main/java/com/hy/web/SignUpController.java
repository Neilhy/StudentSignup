package com.hy.web;

import com.hy.domain.Admin;
import com.hy.domain.Student;
import com.hy.service.ExcelFileGenerator;
import com.hy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by NeilHY on 2016/8/31.
 */
@Controller
public class SignUpController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Long addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @RequestMapping(value = "/LLogin", method = RequestMethod.POST)
    public String getStudents(Admin admin,Model model) {
        if (admin.getName().equals("admin") && admin.getPwd().equals("scut")) {
            List<Student> students=studentService.getAllStudents();
            if (model.containsAttribute("studentList")) {
                Map<String, List<Student>> map = new HashMap<>();
                map.put("studentList",students);
                map.put("error", null);
                model.mergeAttributes(map);
            }else {
                model.addAttribute("studentList", students);
            }
            return "showStudents";
        }else {
            if (model.containsAttribute("error")) {
                Map<String, String> map = new HashMap<>();
                map.put("error", "错误");
                model.mergeAttributes(map);
            }else{
                model.addAttribute("error", "错误");
            }
            return "login";
        }
    }

    @RequestMapping(value = "/getFile",method = RequestMethod.GET)
    public String getFile(HttpServletResponse response) {
        List<Student> students=studentService.getAllStudents();
        ArrayList<ArrayList> rows = new ArrayList<>();
        for (Student student : students) {
            ArrayList<String> row = new ArrayList<>();
            row.add(student.getStudentName());
            row.add(student.getPhoneNumber().toString());
            row.add(student.getCollege());
            row.add(student.getGrade().toString());
            row.add(student.getClassName());
            row.add(student.getSignUpTime().toString());
            row.add(student.getSelfIntroduction());
            row.add(student.getHonor());
            rows.add(row);
        }

        ArrayList<String> headers = new ArrayList<>();
        String[]header={"学生姓名","电话号码","学院","年级","班级","报名时间","自我介绍","获得荣誉"};
        for (String h : header) {
            headers.add(h);
        }

        try {
            OutputStream out = response.getOutputStream();
            response.reset();
            response.setContentType("application/vnd.ms-excel");
            ExcelFileGenerator generator = new ExcelFileGenerator(headers, rows);
            generator.expordExcel(out);
            System.setOut(new PrintStream(out));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "export";
    }
}
