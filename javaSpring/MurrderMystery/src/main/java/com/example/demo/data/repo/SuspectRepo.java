package com.example.demo.data.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.Suspect;

@Repository
public interface SuspectRepo extends JpaRepository<Suspect, Integer>{
	
	List<Suspect> findByNameIgnoreCase(String name);
}
