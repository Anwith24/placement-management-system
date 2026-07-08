package com.anwith.placementmanagement.controller;

import com.anwith.placementmanagement.entity.Recruiter;
import com.anwith.placementmanagement.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @GetMapping("/recruiter/register")
    public String showRecruiterRegistration() {
        return "recruiter-register";
    }
    @PostMapping("/saveRecruiter")
    public String saveRecruiter(@ModelAttribute Recruiter recruiter) {

        recruiterService.saveRecruiter(recruiter);

        return "success";
    }
    @GetMapping("/recruiter/login")
    public String showRecruiterLogin() {
        return "recruiter-login";
    }
    @PostMapping("/recruiter/login")
    public String loginRecruiter(@RequestParam String email,
                                 @RequestParam String password) {

        Recruiter recruiter = recruiterService.loginRecruiter(email, password);

        if (recruiter != null) {
            return "recruiter-dashboard";
        } else {
            return "recruiter-login";
        }
    }
}