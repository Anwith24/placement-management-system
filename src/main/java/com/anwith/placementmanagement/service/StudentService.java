package com.anwith.placementmanagement.service;

import com.anwith.placementmanagement.entity.student;
import com.anwith.placementmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public student saveStudent(student student) {
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
}