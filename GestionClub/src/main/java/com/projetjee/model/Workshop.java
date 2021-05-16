package com.projetjee.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

public class Workshop implements Activity{
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", nullable=false, unique=true, length=11)
	public Long Id;
	
	@Column(name="Date",nullable=false, unique=true, length=20)
	public String date;
	
	@Column(name="Subject",nullable=false, unique=true, length=20)
	public String subject;
	
	@Column(name="Instructor",nullable=false, unique=true, length=20)
	public String instructor;

	@Column(name="InstructorContact",nullable=false, unique=true, length=20)
	public String contact;
	
	@OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
	 private List<Club> clubs;

	public Workshop(String date, String subject, String instructor, String contact, List<Club> clubs) {
		super();
		this.date = date;
		this.subject = subject;
		this.instructor = instructor;
		this.contact = contact;
		this.clubs = clubs;
	}

	
	public Workshop() {
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<Club> getClubs() {
		return clubs;
	}

	public void setClubs(List<Club> clubs) {
		this.clubs = clubs;
	}
	
	
}
