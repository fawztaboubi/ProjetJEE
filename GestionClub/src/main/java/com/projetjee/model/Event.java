package com.projetjee.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Event")

public class Event implements Activity {

	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", nullable=false, unique=true, length=11)
	public Long Id;
	
	@Column(name="Date",nullable=false, unique=true, length=20)
	public String date;
	
	@Column(name="Name",nullable=false, unique=true, length=20)
	public String name;
	
	@Column(name="Budjet",nullable=false, unique=true, length=20)
	public float budjet;
	
	
	
	@OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
	 private List<Club> clubs;



	public Event(String date, String name, float budjet, List<Club> clubs) {
		super();
		this.date = date;
		this.name = name;
		this.budjet = budjet;
		this.clubs = clubs;
	}



	public Event() {
		super();
	}



	public Long getId() {
		return Id;
	}



	public void setId(Long id) {
		Id = id;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public float getBudjet() {
		return budjet;
	}



	public void setBudjet(float budjet) {
		this.budjet = budjet;
	}



	public List<Club> getClubs() {
		return clubs;
	}



	public void setClubs(List<Club> clubs) {
		this.clubs = clubs;
	}
	
	
}
