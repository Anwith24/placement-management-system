package com.anwith.placementmanagement.repository;

import com.anwith.placementmanagement.entity.student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<student, Integer> {
    student findByEmail(String email);

}