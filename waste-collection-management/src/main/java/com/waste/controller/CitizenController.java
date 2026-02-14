package com.waste.controller;

import com.waste.domain.Citizen;
import com.waste.domain.Complaint;
import com.waste.domain.Feedback;
import com.waste.service.CitizenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/citizen")
public class CitizenController {

    private final CitizenService citizenService;

    public CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "citizen-login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String citizenName,
                        @RequestParam String password,
                        Model model) {
        Citizen citizen = citizenService.login(citizenName, password);
        if (citizen == null) {
            model.addAttribute("error", "Invalid credentials");
            return "citizen-login";
        }
        return "redirect:/citizen/dashboard?city=" + citizen.getCity() + "&zone=" + citizen.getZone();
    }

    @GetMapping("/dashboard")
    public String dashboard(@RequestParam String city,
                            @RequestParam String zone,
                            @RequestParam Long citizenId,
                            Model model) {
        model.addAttribute("schedules", citizenService.getSchedules(city, zone));
        model.addAttribute("complaints", citizenService.getComplaints(citizenId));
        model.addAttribute("feedback", citizenService.getFeedback(zone));
        return "citizen-dashboard";
    }

    @PostMapping("/complaint/add")
    public String addComplaint(@RequestParam String complaintId,
                               @RequestParam String issue,
                               @RequestParam String address,
                               @RequestParam String requestedDate,
                               @RequestParam String city,
                               @RequestParam String zone,
                               @RequestParam Long citizenId) {
        citizenService.addComplaint(complaintId, issue, address, requestedDate, city, zone, citizenId);
        return "redirect:/citizen/dashboard?city=" + city + "&zone=" + zone + "&citizenId=" + citizenId;
    }

    @PostMapping("/feedback/add")
    public String addFeedback(@RequestParam String message,
                              @RequestParam String zone,
                              @RequestParam Long citizenId) {
        citizenService.addFeedback(message, zone, citizenId);
        return "redirect:/citizen/dashboard?city=" + citizenService.getCity(citizenId) +
               "&zone=" + zone + "&citizenId=" + citizenId;
    }
}
