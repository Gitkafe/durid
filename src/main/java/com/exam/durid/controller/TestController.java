package com.exam.durid.controller;

import com.exam.durid.dao.cluster.DictMapper;
import com.exam.durid.dao.master.StudentMapper;
import com.exam.durid.model.Dict;
import com.exam.durid.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private DictMapper dictMapper;

    @RequestMapping("/")
    public String index() {
        return "main";
    }

    @RequestMapping("/getStudentList")
    public String getStudentList(Model model) {
        List<Student> studentList = studentMapper.getAll();
        model.addAttribute("users", studentList);
        return "studentList";
    }

    @RequestMapping("/getDictList")
    public String getDictList(Model model) {
        List<Dict> dictList = dictMapper.getAll();
        model.addAttribute("dicts", dictList);
        return "dictList";
    }


}
