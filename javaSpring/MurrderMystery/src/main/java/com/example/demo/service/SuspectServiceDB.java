package com.example.demo.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.data.Suspect;
import com.example.demo.data.repo.SuspectRepo;

@Service
@Primary
public class SuspectServiceDB implements SuspectService{

	private SuspectRepo repo;
	
	public SuspectServiceDB(SuspectRepo repo) {
		super();
		this.repo=repo;
	}
	
	@Override
	public Suspect createSuspect(Suspect suspect) {
		// TODO Auto-generated method stub
		return repo.save(suspect);
	}

	@Override
	public List<Suspect> getAllSuspects() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Suspect getSuspect(int id) {
		// TODO Auto-generated method stub
		Suspect found = repo.findById(id).get();
		return found;
	}

	@Override
	public Suspect replaceSuspect(int id, Suspect newSuspect) {
		// TODO Auto-generated method stub
		Suspect found = repo.findById(id).get();
		
		found.setName(newSuspect.getName());
		found.setWepon(newSuspect.getWepon());
		found.setLocation(newSuspect.getLocation());
		found.setJob(newSuspect.getJob());
		found.setPercentageSus(newSuspect.getPercentageSus());
		
		Suspect updated = repo.save(found);
		return updated;
	}

	@Override
	public String deleteSuspect(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
		if(repo.existsById(id)) {
			return "Not deleted:"+id;
		}else {
			return "Deleted:"+id;
		}
	}

	@Override
	public List<Suspect> getByName(String name) {
		// TODO Auto-generated method stub
		return repo.findByNameIgnoreCase(name);
	}

}

