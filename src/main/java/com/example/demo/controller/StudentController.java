package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.responsemodels.StudentResponse;
import com.example.demo.service.StudentService;
import com.example.demo.utils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/student/")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);
    private final StudentService studentService;

    private static Function<Student, StudentResponse> getStudentResponseFunction() {
        return student -> {
            StudentResponse studentResponse = new StudentResponse();
            BeanUtils.copyProperties(student, studentResponse);
            return studentResponse;
        };
    }

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // http://localhost:8080/api/student/getAll
    @GetMapping("getAll")
    public List<StudentResponse> getAllStudents() {
        logger.info("Inside getAllStudents method");

        List<Student> studentList = studentService.getAllStudents();

        List<StudentResponse> studentResponseList =  studentList.stream().map(getStudentResponseFunction()).collect(Collectors.toList());
        return studentResponseList;
    }

    /*
    @RequestMapping("/env")
    public @ResponseBody Map<String, String> env() {
        return System.getenv();
    }
    /* */


}
