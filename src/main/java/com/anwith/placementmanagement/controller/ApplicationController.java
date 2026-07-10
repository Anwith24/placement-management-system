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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;
import com.anwith.placementmanagement.entity.student;


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
    public String applyForJob(@PathVariable Integer id, HttpSession session) {

        Job job = jobService.getJobById(id);

        student loggedInStudent = (student) session.getAttribute("loggedInStudent");

        if (loggedInStudent == null) {
            return "redirect:/student/login";
        }

        Application existingApplication =
                applicationService.getApplicationByStudentAndJob(
                        loggedInStudent.getEmail(),
                        job.getJobTitle());

        if (existingApplication != null) {
            return "already-applied";
        }

        Application application = new Application();

        application.setStudentName(loggedInStudent.getName());
        application.setStudentEmail(loggedInStudent.getEmail());

        application.setJobTitle(job.getJobTitle());
        application.setCompanyName(job.getCompanyName());
        application.setStatus("Applied");

        applicationService.saveApplication(application);

        return "redirect:/myApplications";
    }
    @GetMapping("/application/edit/{id}")
    public String editApplication(@PathVariable Integer id, Model model) {

        model.addAttribute("app", applicationService.getApplicationById(id));

        return "edit-application";
    }
    @PostMapping("/application/update")
    public String updateApplication(@ModelAttribute Application application) {

        applicationService.updateApplication(application);

        return "redirect:/applications";
    }
    @GetMapping("/myApplications")
    public String myApplications(HttpSession session, Model model) {

        student loggedInStudent =
                (student) session.getAttribute("loggedInStudent");

        if (loggedInStudent == null) {
            return "redirect:/student/login";
        }

        model.addAttribute(
                "applications",
                applicationService.getApplicationsByStudentEmail(
                        loggedInStudent.getEmail())
        );

        return "my-applications";
    }
}