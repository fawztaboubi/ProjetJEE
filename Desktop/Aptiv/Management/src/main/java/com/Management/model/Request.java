package com.Management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="Request")
public class Request {

	//a request should contain the necessary information to create a new user and add it to the data base
		//Name, Job,Contact,Team
		
		//this request will be sent to team manager and when he approves and sets access rights an email is sent to the user via the contact he provided
		@javax.persistence.Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		
		@Column(name="Id", nullable=false, unique=true, length=11)
		public int Id;
		
		
		@Column(name="Job", nullable=false, length=20)
		public String Job;
		
		@Column(name="Name", nullable=false, length=20)
		public String Name;
		
		@Column(name="FamilyName", nullable=false, length=20)
		public String FamilyName;
		
		
		@Column(name="Email", nullable=false, length=25)
		public String Email;
		
		//a request team can be sent to join one an only one team??

		public int getId() {
			return Id;
		}

		public void setId(int id) {
			Id = id;
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

		public String Job() {
			return Job;
		}

		public void setJob(String job) {
			Job = job;
		}


		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}
}
