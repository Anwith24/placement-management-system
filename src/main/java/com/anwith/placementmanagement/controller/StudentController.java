package com.anwith.placementmanagement.controller;

import com.anwith.placementmanagement.entity.student;
import com.anwith.placementmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/register")
    public String registerPage() {
        return "student-register";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute student student) {

        studentService.saveStudent(student);

        return "success";
    }
    @GetMapping("/students")
    public String viewStudents(Model model) {

        model.addAttribute("students", studentService.getAllStudents());

        return "student-list";
    }
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Integer id) {

        studentService.deleteStudent(id);

        return "redirect:/students";
    }
    @GetMapping("/editStudent/{id}")
    public String editStudent(@PathVariable Integer id, Model model) {

        student student = studentService.getStudentById(id);

        model.addAttribute("student", student);

        return "edit-student";
    }
    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute student student) {

        studentService.saveStudent(student);

        return "redirect:/students";
    }
}