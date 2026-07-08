package com.anwith.placementmanagement.repository;

import com.anwith.placementmanagement.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {

}