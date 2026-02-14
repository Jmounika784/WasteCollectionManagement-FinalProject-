package com.waste.dao;

import com.waste.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackDao extends JpaRepository<Feedback, Integer> {
    List<Feedback> findByZone(String zone);
}
