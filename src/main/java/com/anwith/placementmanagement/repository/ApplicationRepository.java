package com.anwith.placementmanagement.repository;

import com.anwith.placementmanagement.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    List<Application> findByStudentEmail(String studentEmail);
    Application findByStudentEmailAndJobTitle(String studentEmail, String jobTitle);

}