package com.jay.Springsecdemo.Repository;

import com.jay.Springsecdemo.model.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
    Student findByUsername(String username);
}