package com.anwith.placementmanagement.service;

import com.anwith.placementmanagement.entity.Application;
import com.anwith.placementmanagement.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public void saveApplication(Application application) {
        applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }
    public Application getApplicationById(Integer id) {
        return applicationRepository.findById(id).orElse(null);
    }

    public void updateApplication(Application application) {
        applicationRepository.save(application);
    }
    public List<Application> getApplicationsByStudentEmail(String email) {
        return applicationRepository.findByStudentEmail(email);
    }
}