package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.data.Suspect;

@Service
public class SuspectServiceList implements SuspectService {

	private List<Suspect> suspects = new ArrayList<>();
	
	@Override
	public Suspect createSuspect(Suspect Suspect) {
		// TODO Auto-generated method stub
		suspects.add(Suspect);
		return suspects.get(suspects.size()-1);
	}

	@Override
	public List<Suspect> getAllSuspects() {
		// TODO Auto-generated method stub
		return suspects;
	}

	@Override
	public Suspect getSuspect(int id) {
		// TODO Auto-generated method stub
		return suspects.get(id);
	}

	@Override
	public Suspect replaceSuspect(int id, Suspect Suspect) {
		// TODO Auto-generated method stub
		return suspects.set(id, Suspect);
		
	}

	@Override
	public String deleteSuspect(int id) {
		// TODO Auto-generated method stub
		suspects.remove(id);
		return "Deleted Suspect at index "+id;
	}

	@Override
	public List<Suspect> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
