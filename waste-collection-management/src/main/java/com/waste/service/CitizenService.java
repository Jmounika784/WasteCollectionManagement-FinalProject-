package com.waste.service;

import com.waste.dao.*;
import com.waste.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenService {

    private final CitizenDao citizenDao;
    private final CollectionScheduleDao scheduleDao;
    private final ComplaintDao complaintDao;
    private final FeedbackDao feedbackDao;

    public CitizenService(CitizenDao citizenDao,
                          CollectionScheduleDao scheduleDao,
                          ComplaintDao complaintDao,
                          FeedbackDao feedbackDao) {
        this.citizenDao = citizenDao;
        this.scheduleDao = scheduleDao;
        this.complaintDao = complaintDao;
        this.feedbackDao = feedbackDao;
    }

    public Citizen login(String userId, String password) {
        return citizenDao.findByUserIdAndPassword(userId, password).orElse(null);
    }

    public List<CollectionSchedule> getSchedules(String zone, String zone2) {
        return scheduleDao.findByZone(zone);
    }

    public void raiseComplaint(Complaint complaint) {
        complaint.setStatus("Open");
        complaintDao.save(complaint);
    }

    public List<Complaint> getComplaints(String city, String zone) {
        return complaintDao.findByCityAndZone(city, zone);
    }

    public void giveFeedback(Feedback feedback) {
        feedbackDao.save(feedback);
    }

    public List<Feedback> getFeedback(String zone) {
        return feedbackDao.findByZone(zone);
    }

	public Object getComplaints(Long citizenId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addComplaint(String complaintId, String issue, String address, String requestedDate, String city,
			String zone, Long citizenId) {
		// TODO Auto-generated method stub
		
	}

	public void addFeedback(String message, String zone, Long citizenId) {
		// TODO Auto-generated method stub
		
	}

	public String getCity(Long citizenId) {
		// TODO Auto-generated method stub
		return null;
	}
}
