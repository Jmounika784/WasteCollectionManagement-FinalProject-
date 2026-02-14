package com.waste.service;

import com.waste.dao.*;
import com.waste.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectorService {

    private final CollectorDao collectorDao;
    private final CollectionScheduleDao scheduleDao;
    private final ComplaintDao complaintDao;
    private final FeedbackDao feedbackDao;

    public CollectorService(CollectorDao collectorDao,
                            CollectionScheduleDao scheduleDao,
                            ComplaintDao complaintDao,
                            FeedbackDao feedbackDao) {
        this.collectorDao = collectorDao;
        this.scheduleDao = scheduleDao;
        this.complaintDao = complaintDao;
        this.feedbackDao = feedbackDao;
    }

    public Collector login(String name, String password) {
        return collectorDao.findByCollectorNameAndPassword(name, password).orElse(null);
    }

    public List<CollectionSchedule> getSchedules(String zone) {
        return scheduleDao.findByZone(zone);
    }

    public List<Complaint> getComplaints(String zone) {
        return complaintDao.findByZone(zone);
    }

    public void updateComplaintStatus(Integer id, String status) {
        Complaint c = complaintDao.findById(id).orElseThrow();
        c.setStatus(status);
        complaintDao.save(c);
    }

    public List<Feedback> getFeedback(String zone) {
        return feedbackDao.findByZone(zone);
    }
}
