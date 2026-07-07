package com.anwith.placementmanagement.service;

import com.anwith.placementmanagement.entity.Recruiter;
import com.anwith.placementmanagement.repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;

    public void saveRecruiter(Recruiter recruiter) {
        recruiterRepository.save(recruiter);
    }

    public List<Recruiter> getAllRecruiters() {
        return recruiterRepository.findAll();
    }
}