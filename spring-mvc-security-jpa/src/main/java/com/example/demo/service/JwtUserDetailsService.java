package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.entity.Student;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepository.findById(Long.parseLong(username))
                .orElseThrow(() -> new UsernameNotFoundException("Student not found with id: " + username));

        // Assuming the role for students is "ROLE_STUDENT"
        Role role = roleRepository.findByName("ROLE_STUDENT")
                .orElseThrow(() -> new UsernameNotFoundException("Role not found"));

        return new User(username, student.getAddress(), Collections.singleton(new SimpleGrantedAuthority(role.getName().name())));
    }
}
