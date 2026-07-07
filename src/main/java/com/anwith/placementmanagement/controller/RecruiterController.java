package com.anwith.placementmanagement.controller;

import com.anwith.placementmanagement.entity.Recruiter;
import com.anwith.placementmanagement.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

}