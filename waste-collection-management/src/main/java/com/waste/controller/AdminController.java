package com.waste.controller;

import com.waste.domain.Admin;
import com.waste.domain.CollectionSchedule;
import com.waste.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "admin-login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String userId,
                        @RequestParam String password,
                        Model model) {

        Admin admin = adminService.login(userId, password);

        if (admin == null) {
            model.addAttribute("error", "Invalid credentials");
            return "admin-login";
        }

        return "redirect:/admin/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("collectors", adminService.getCollectors());
        model.addAttribute("citizens", adminService.getCitizens());
        model.addAttribute("schedules", adminService.getAllSchedules());
        model.addAttribute("complaints", adminService.getAllComplaints());
        model.addAttribute("feedback", adminService.getAllFeedback());
        return "admin-dashboard";
    }
}
