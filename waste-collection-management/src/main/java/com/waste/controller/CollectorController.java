package com.waste.controller;

import com.waste.domain.Collector;
import com.waste.service.CollectorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/collector")
public class CollectorController {

    private final CollectorService collectorService;

    public CollectorController(CollectorService collectorService) {
        this.collectorService = collectorService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "collector-login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String collectorName,
                        @RequestParam String password,
                        Model model) {
        Collector collector = collectorService.login(collectorName, password);
        if (collector == null) {
            model.addAttribute("error", "Invalid credentials");
            return "collector-login";
        }
        return "redirect:/collector/dashboard?zone=" + collector.getZone();
    }

    @GetMapping("/dashboard")
    public String dashboard(@RequestParam String zone, Model model) {
        model.addAttribute("zone", zone);
        model.addAttribute("schedules", collectorService.getSchedules(zone));
        model.addAttribute("complaints", collectorService.getComplaints(zone));
        model.addAttribute("feedback", collectorService.getFeedback(zone));
        return "collector-dashboard";
    }

    @PostMapping("/complaint/update/{id}")
    public String updateComplaint(@PathVariable Integer id,
                                  @RequestParam String status,
                                  @RequestParam String zone) {
        collectorService.updateComplaintStatus(id, status);
        return "redirect:/collector/dashboard?zone=" + zone;
    }
}
