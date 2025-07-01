package com.reclamo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reclamo.entity.Reclamo;

public interface ReclamoRepository extends JpaRepository<Reclamo, Long> {
	
	

}
