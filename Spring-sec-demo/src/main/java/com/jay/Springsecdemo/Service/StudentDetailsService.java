package com.jay.Springsecdemo.Service;

import com.jay.Springsecdemo.Repository.StudentRepo;
import com.jay.Springsecdemo.model.Student;
import com.jay.Springsecdemo.model.UserPrincple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;
@Service
public class StudentDetailsService implements UserDetailsService {
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student=studentRepo.findByUsername(username);
        if(student==null){
            throw new UsernameNotFoundException("User not Found");
        }
        return new UserPrincple(student);
    }
}
