package com.anwith.placementmanagement.repository;

import com.anwith.placementmanagement.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Integer> {

    List<Job> findByJobTitleContainingIgnoreCase(String jobTitle);

}