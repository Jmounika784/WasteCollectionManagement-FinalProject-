package com.waste.dao;

import com.waste.domain.Collector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CollectorDao extends JpaRepository<Collector, Integer> {
    Optional<Collector> findByCollectorNameAndPassword(String collectorName, String password);
    List<Collector> findByZone(String zone);
}
