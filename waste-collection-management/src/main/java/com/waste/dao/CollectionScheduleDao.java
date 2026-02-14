package com.waste.dao;

import com.waste.domain.CollectionSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectionScheduleDao extends JpaRepository<CollectionSchedule, Integer> {
    List<CollectionSchedule> findByZone(String zone);
}
