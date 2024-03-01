package com.jay.Springsecdemo.Controller;

import com.jay.Springsecdemo.Service.StudentService;
import com.jay.Springsecdemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("register")
    public ResponseEntity<String> Register(@RequestBody Student student){
        return studentService.Register(student);
    }

}
