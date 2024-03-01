package com.jay.Springsecdemo.Service;

import com.jay.Springsecdemo.Repository.StudentRepo;
import com.jay.Springsecdemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(12);
    public ResponseEntity<String> Register(Student student) {
        student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
        studentRepo.save(student);
        return new ResponseEntity<>("Registered", HttpStatus.CREATED);
    }
}
