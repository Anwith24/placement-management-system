package com.anwith.placementmanagement.repository;

import com.anwith.placementmanagement.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

}