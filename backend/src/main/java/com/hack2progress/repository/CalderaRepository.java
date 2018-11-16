package com.hack2progress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hack2progress.model.Caldera;

@Repository
public interface CalderaRepository extends JpaRepository<Caldera, Long> {
	
}
