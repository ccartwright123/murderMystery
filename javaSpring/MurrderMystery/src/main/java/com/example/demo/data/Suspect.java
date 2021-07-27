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
	private String percentageSus;
	
	
	
	public Suspect(int id, String name,String wepon,String location, String job, String percentageSus) {
		super();
		this.id =id;
		this.name=name;
		this.wepon=wepon;
		this.location=location;
		this.job=job;
		this.percentageSus=percentageSus;
	}
	public Suspect(String name,String wepon,String location, String job, String percentageSus) {
		super();
		this.name=name;
		this.location=location;
		this.job=job;
		this.percentageSus=percentageSus;
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


	public String getPercentageSus() {
		return percentageSus;
	}


	public void setPercentageSus(String percentageSus) {
		this.percentageSus = percentageSus;
	}
	
	@Override
	public String toString() {
		return "Suspect [id=" + id + ", name=" + name + ", wepon=" + wepon + ", location=" + location + ", job=" + job
				+ ", percentageSus=" + percentageSus + "]";
	}
	
}
