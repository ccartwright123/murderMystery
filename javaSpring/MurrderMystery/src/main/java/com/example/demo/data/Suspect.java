package com.example.demo.data;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Suspect {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String wepon;
	private String location;
	private String job;
	private int percentageSus;
	
	
	
	public Suspect(int id, String name,String wepon,String location, String job, int percentageSus) {
		super();
		this.id =id;
		this.name=name;
		this.wepon=wepon;
		this.location=location;
		this.job=job;
		setPercentageSus();
	}
	public Suspect(String name,String wepon,String location, String job, int percentageSus) {
		super();
		this.name=name;
		this.location=location;
		this.job=job;
		setPercentageSus();
	}
	public Suspect(String name,String wepon,String location, String job) {
		super();
		this.name=name;
		this.location=location;
		this.job=job;
		setPercentageSus();
	}
	public Suspect() {
		
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id, job, location, name, percentageSus, wepon);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Suspect other = (Suspect) obj;
		return id == other.id && Objects.equals(job, other.job) && Objects.equals(location, other.location)
				&& Objects.equals(name, other.name) && Objects.equals(percentageSus, other.percentageSus)
				&& Objects.equals(wepon, other.wepon);
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getWepon() {
		return wepon;
	}


	public void setWepon(String wepon) {
		this.wepon = wepon;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public int getPercentageSus() {
		return percentageSus;
	}


	public void setPercentageSus() {
		percentageSus=0;
		String weapon = getWepon();
		String locate = getLocation();
		switch (weapon) {
		case "sword":
			percentageSus=percentageSus +10;
			break;
		case "rope":
			percentageSus= percentageSus + 35;
			break;
		case "gun":
			percentageSus= percentageSus + 15;
			break;
		case "hammer":
			percentageSus= percentageSus + 25;
			break;
		}
		switch (locate) {
		case "garden":
			percentageSus=percentageSus +10;
			break;
		case "living room":
			percentageSus= percentageSus + 25;
			break;
		case "bedroom":
			percentageSus= percentageSus + 35;
			break;
		case "car":
			percentageSus= percentageSus + 20;
			break;
		}
		
	}
	
	@Override
	public String toString() {
		return "Suspect [id=" + id + ", name=" + name + ", wepon=" + wepon + ", location=" + location + ", job=" + job
				+ ", percentageSus=" + percentageSus + "]";
	}
	
}
