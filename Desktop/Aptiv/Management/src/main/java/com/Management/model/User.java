package com.Management.model;

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

@Entity
@Table(name="user")
public class User {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", nullable=false, unique=true, length=11)
	public int Id;
	
	@Column(name="Name",nullable=false, unique=false, length=20)
	public String Name;
	
	@Column(name="FamilyName", nullable=false, unique=false, length=20)
	public String FamilyName;
	
	@Column(name="Department", nullable=true, length=20)
	public String Department;
	
	@Column(name="Job", nullable=false, length=20)
	public int Job;
	
	@Column(name="Email", nullable=false, length=25)
	public String Email;
	
	//let's add the boolean variables for access rights
	
	@Column(name="add_Action", nullable=false, length=25)
	public Boolean add_Action;
	
	@Column(name="modify_Action", nullable=false, length=25)
	public Boolean modify_Action;
	
	@Column(name="add_Action_Plan", nullable=false, length=25)
	public Boolean add_Action_Plan;
	
	@Column(name="modify_Action_Plan", nullable=false, length=25)
	public Boolean modify_Action_Plan;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Action> actions;
	
	@ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

	


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

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}


	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getJob() {
		return Job;
	}

	public void setJob(int job) {
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

}
