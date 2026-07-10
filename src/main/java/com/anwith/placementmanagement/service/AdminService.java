package com.anwith.placementmanagement.service;

import com.anwith.placementmanagement.entity.Admin;
import com.anwith.placementmanagement.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin loginAdmin(String username, String password) {
        return adminRepository.findByUsernameAndPassword(username, password);
    }
}