package com.Aptiv.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="response")
public class Response {
	

	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", nullable=false, unique=true, length=11)
	public Long Id;
	
	@Column(name="toEmail" ,nullable=false, length=300)
		public String toEmail;

	@Column(name="department" ,nullable=false, length=300)
		public String department;

	@Column(name="username" ,nullable=false, length=300)
		public String username;
	
	@Column(name="password" ,nullable=false, length=300)
		public String password;

	
		public String getToEmail() {
			return toEmail;
		}

		public void setToEmail(String toEmail) {
			this.toEmail = toEmail;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		
		
		

}

