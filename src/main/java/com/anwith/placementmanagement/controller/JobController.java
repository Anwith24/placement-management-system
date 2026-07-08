package com.anwith.placementmanagement.controller;

import com.anwith.placementmanagement.entity.Job;
import com.anwith.placementmanagement.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/job/register")
    public String showJobRegisterPage() {
        return "job-register";
    }
    @PostMapping("/saveJob")
    public String saveJob(@ModelAttribute Job job) {

        jobService.saveJob(job);

        return "success";
    }
    @GetMapping("/jobs")
    public String viewJobs(Model model) {

        model.addAttribute("jobs", jobService.getAllJobs());

        return "job-list";
    }
    @GetMapping("/job/delete/{id}")
    public String deleteJob(@PathVariable Integer id) {

        jobService.deleteJob(id);

        return "redirect:/jobs";
    }
    @GetMapping("/job/edit/{id}")
    public String editJob(@PathVariable Integer id, Model model) {

        model.addAttribute("job", jobService.getJobById(id));

        return "edit-job";
    }
    @PostMapping("/updateJob")
    public String updateJob(@ModelAttribute Job job) {

        jobService.saveJob(job);

        return "redirect:/jobs";
    }
}