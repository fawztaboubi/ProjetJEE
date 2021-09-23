package com.Aptiv.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonMappingException;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="user")
public class User implements Serializable{
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", nullable=false, unique=true, length=11)
	public Long Id;
	
	@Column(name="Name",nullable=false, unique=false, length=20)
	public String Name;
	
	@Column(name="FamilyName", nullable=false, unique=false, length=20)
	public String FamilyName;
	
	@Column(name="department", nullable=true, length=20)
	public String department;
	
	@Column(name="Job", nullable=false, length=50)
	public String Job;
	
	@Column(name="Password", nullable=false, length=25)
	public String Password;
	
	@Column(name="username", nullable=false, length=25)
	public String username;
	
	@Column(name="email", nullable=true, length=25)
	public String email;
	
	
	//let's add the boolean variables for access rights
	
	@Column(name="add_Action", nullable=true, length=25)
	public Boolean add_Action;
	
	@Column(name="modify_Action", nullable=true, length=25)
	public Boolean modify_Action;
	
	@Column(name="add_Action_Plan", nullable=true, length=25)
	public Boolean add_Action_Plan;
	
	@Column(name="modify_Action_Plan", nullable=true, length=25)
	public Boolean modify_Action_Plan;
	
	@Column(name="import", nullable=true, length=25)
	public Boolean Import;
	
	@Column(name="export", nullable=true, length=25)
	public Boolean Export;
	
	
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Action> actions;
	
	@ManyToOne
    @JoinColumn(name = "department_id")
    private Department depar;


	public Boolean getImport() {
		return Import;
	}

	public void setImport(Boolean import1) {
		Import = import1;
	}

	public Boolean getExport() {
		return Export;
	}

	public void setExport(Boolean export) {
		Export = export;
	}
	
	public void setDepartment(Department department) {
		this.depar = department;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String depar) {
		department = depar;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		email = mail;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}


	public String getJob() {
		return Job;
	}

	public void setJob(String job) {
		Job = job;
	}

	public Boolean getAdd_Action() {
		return add_Action;
	}

	public void setAdd_Action(Boolean add_Action) {
		this.add_Action = add_Action;
	}

	public Boolean getModify_Action() {
		return modify_Action;
	}

	public void setModify_Action(Boolean modify_Action) {
		this.modify_Action = modify_Action;
	}

	public Boolean getAdd_Action_Plan() {
		return add_Action_Plan;
	}

	public void setAdd_Action_Plan(Boolean add_Action_Plan) {
		this.add_Action_Plan = add_Action_Plan;
	}

	public Boolean getModify_Action_Plan() {
		return modify_Action_Plan;
	}

	public void setModify_Action_Plan(Boolean modify_Action_Plan) {
		this.modify_Action_Plan = modify_Action_Plan;
	}

	public String getUsername() {
		
		return username;
	}






}
