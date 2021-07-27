package com.example.demo.service;

import java.util.List;

import com.example.demo.data.Suspect;

public interface SuspectService {
	
	public Suspect createSuspect(Suspect Suspect);
	
	public List<Suspect> getAllSuspects();
	
	public Suspect getSuspect(int id);
	
	public Suspect replaceSuspect(int id, Suspect Suspect);
	
	public String deleteSuspect(int id);
	
	public List<Suspect> getByName(String name);
}
