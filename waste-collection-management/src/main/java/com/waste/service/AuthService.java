// AuthService.java
package com.waste.service;

import com.waste.dao.AdminDao;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AdminDao adminDao;

    public AuthService(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public boolean validateAdmin(String username, String password) {
        return adminDao.findByUserIdAndPassword(username, password).isPresent();
    }
}
