package com.anwith.placementmanagement.service;

import com.anwith.placementmanagement.entity.Job;
import com.anwith.placementmanagement.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public void saveJob(Job job) {
        jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    public void deleteJob(Integer id) {
        jobRepository.deleteById(id);
    }
    public Job getJobById(Integer id) {
        return jobRepository.findById(id).orElse(null);
    }
}