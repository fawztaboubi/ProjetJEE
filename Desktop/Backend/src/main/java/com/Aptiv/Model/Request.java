package com.Aptiv.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="request")
public class Request {

	//a request should contain the necessary information to create a new user and add it to the data base
		//Name, Job,Contact,Team
		
		//this request will be sent to team manager and when he approves and sets access rights an email is sent to the user via the contact he provided
		@javax.persistence.Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		
		@Column(name="Id", nullable=false, unique=true, length=11)
		public Long Id;
		
		
		@Column(name="job", nullable=false, length=20)
		public String Job;
		
		@Column(name="name", nullable=false, length=20)
		public String Name;
		
		@Column(name="familyName", nullable=false, length=20)
		public String FamilyName;
		
		
		@Column(name="email", nullable=true, length=25)
		public String Email;
		
		@Column(name="status", nullable=true, length=25)
		public String Status;
		//a request team can be sent to join one an only one team??
        //define status of type enumeration (still on hold, approved or refused)
		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}

		public String getJob() {
			return Job;
		}

		public void setJob(String job) {
			Job = job;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public String getFamilyName() {
			return FamilyName;
		}

		public void setFamilyName(String familyName) {
			FamilyName = familyName;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}

		public String getStatus() {
			return Status;
		}

		public void setStatus(String status) {
			Status = status;
		}

		





}
