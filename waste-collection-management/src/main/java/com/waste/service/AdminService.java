package com.waste.service;

import com.waste.dao.*;
import com.waste.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminDao adminDao;
    private final CollectorDao collectorDao;
    private final CitizenDao citizenDao;
    private final CollectionScheduleDao scheduleDao;
    private final ComplaintDao complaintDao;
    private final FeedbackDao feedbackDao;

    public AdminService(AdminDao adminDao,
                        CollectorDao collectorDao,
                        CitizenDao citizenDao,
                        CollectionScheduleDao scheduleDao,
                        ComplaintDao complaintDao,
                        FeedbackDao feedbackDao) {

        this.adminDao = adminDao;
        this.collectorDao = collectorDao;
        this.citizenDao = citizenDao;
        this.scheduleDao = scheduleDao;
        this.complaintDao = complaintDao;
        this.feedbackDao = feedbackDao;
    }

    // LOGIN
    public Admin login(String userId, String password) {
        return adminDao.findByUserIdAndPassword(userId, password).orElse(null);
    }

    // SCHEDULE
    public CollectionSchedule addSchedule(CollectionSchedule schedule) {
        return scheduleDao.save(schedule);
    }

    public List<CollectionSchedule> getAllSchedules() {
        return scheduleDao.findAll();
    }

    // COLLECTORS
    public List<Collector> getCollectors() {
        return collectorDao.findAll();
    }

    public Collector approveCollector(Integer id) {
        Collector c = collectorDao.findById(id).orElseThrow();
        c.setApproved(true);
        return collectorDao.save(c);
    }

    // CITIZENS
    public List<Citizen> getCitizens() {
        return citizenDao.findAll();
    }

    // COMPLAINTS
    public List<Complaint> getAllComplaints() {
        return complaintDao.findAll();
    }

    // FEEDBACK
    public List<Feedback> getAllFeedback() {
        return feedbackDao.findAll();
    }
}
