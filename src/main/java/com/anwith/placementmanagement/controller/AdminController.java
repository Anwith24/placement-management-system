package com.anwith.placementmanagement.controller;

import com.anwith.placementmanagement.entity.Admin;
import com.anwith.placementmanagement.service.AdminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.anwith.placementmanagement.repository.StudentRepository;
import com.anwith.placementmanagement.repository.RecruiterRepository;
import com.anwith.placementmanagement.repository.JobRepository;
import com.anwith.placementmanagement.repository.ApplicationRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin/login")
    public String showAdminLogin() {
        return "admin-login";
    }

    @PostMapping("/admin/login")
    public String loginAdmin(@RequestParam String username,
                             @RequestParam String password,
                             HttpSession session) {

        Admin admin = adminService.loginAdmin(username, password);

        if (admin != null) {

            session.setAttribute("loggedInAdmin", admin);

            return "redirect:/admin/dashboard";
        }

        return "admin-login";
    }
    @GetMapping("/admin/dashboard")
    public String adminDashboard(HttpSession session, Model model) {

        if (session.getAttribute("loggedInAdmin") == null) {
            return "redirect:/admin/login";
        }

        model.addAttribute("studentCount", studentRepository.count());
        model.addAttribute("recruiterCount", recruiterRepository.count());
        model.addAttribute("jobCount", jobRepository.count());
        model.addAttribute("applicationCount", applicationRepository.count());

        return "admin-dashboard";
    }

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping("/admin/logout")
    public String adminLogout(HttpSession session) {

        session.invalidate();

        return "redirect:/admin/login";
    }
    @GetMapping("/admin/students")
    public String manageStudents(Model model,
                                 HttpSession session) {

        if (session.getAttribute("loggedInAdmin") == null) {
            return "redirect:/admin/login";
        }

        model.addAttribute("students", studentRepository.findAll());

        return "admin-student-list";
    }
    @GetMapping("/admin/student/delete/{id}")
    public String deleteStudent(@PathVariable Integer id,
                                HttpSession session) {

        if (session.getAttribute("loggedInAdmin") == null) {
            return "redirect:/admin/login";
        }

        studentRepository.deleteById(id);

        return "redirect:/admin/students";
    }
    @GetMapping("/admin/recruiters")
    public String manageRecruiters(Model model, HttpSession session) {

        if (session.getAttribute("loggedInAdmin") == null) {
            return "redirect:/admin/login";
        }

        model.addAttribute("recruiters", recruiterRepository.findAll());

        return "admin-recruiter-list";
    }

    @GetMapping("/admin/recruiter/delete/{id}")
    public String deleteRecruiter(@PathVariable Integer id,
                                  HttpSession session) {

        if (session.getAttribute("loggedInAdmin") == null) {
            return "redirect:/admin/login";
        }

        recruiterRepository.deleteById(id);

        return "redirect:/admin/recruiters";
    }
}
