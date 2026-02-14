package com.waste.dao;

import com.waste.domain.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintDao extends JpaRepository<Complaint, Integer> {

    // For collector dashboard
    List<Complaint> findByZone(String zone);

    // For citizen dashboard
    List<Complaint> findByCity(String city);

    // If you want to filter by both:
    List<Complaint> findByCityAndZone(String city, String zone);
}
