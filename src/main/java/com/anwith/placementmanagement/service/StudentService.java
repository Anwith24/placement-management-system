package com.anwith.placementmanagement.service;

import com.anwith.placementmanagement.entity.student;
import com.anwith.placementmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public student saveStudent(student student) {

        student.setPassword(passwordEncoder.encode(student.getPassword()));

        return studentRepository.save(student);
    }
    public List<student> getAllStudents() {
        return studentRepository.findAll();
    }
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
    public student getStudentById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }
    public student loginStudent(String email, String password) {

        student stu = studentRepository.findByEmail(email);

        if (stu != null && passwordEncoder.matches(password, stu.getPassword())) {
            return stu;
        }

        return null;
    }
    @Autowired
    private PasswordEncoder passwordEncoder;
}