package com.anwith.placementmanagement.controller;

import com.anwith.placementmanagement.entity.Application;
import com.anwith.placementmanagement.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.anwith.placementmanagement.entity.Job;
import com.anwith.placementmanagement.service.JobService;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/applications")
    public String viewApplications(Model model) {

        model.addAttribute("applications", applicationService.getAllApplications());

        return "application-list";
    }
    @Autowired
    private JobService jobService;

    @GetMapping("/apply/{id}")
    public String applyForJob(@PathVariable Integer id) {

        Job job = jobService.getJobById(id);

        Application application = new Application();

        // Temporary student details
        application.setStudentName("Anwith");
        application.setStudentEmail("anwith@gmail.com");

        application.setJobTitle(job.getJobTitle());
        application.setCompanyName(job.getCompanyName());
        application.setStatus("Applied");

        applicationService.saveApplication(application);

        return "redirect:/applications";
    }
}