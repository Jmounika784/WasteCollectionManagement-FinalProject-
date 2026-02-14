package com.waste.dao;

import com.waste.domain.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CitizenDao extends JpaRepository<Citizen, Integer> {
    Optional<Citizen> findByUserIdAndPassword(String userId, String password);
}
