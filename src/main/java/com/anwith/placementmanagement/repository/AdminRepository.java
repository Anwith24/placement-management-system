package com.anwith.placementmanagement.repository;

import com.anwith.placementmanagement.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByUsernameAndPassword(String username, String password);

}