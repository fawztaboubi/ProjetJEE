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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="theme")

public class Theme implements Serializable{

	//a theme belongs to one and only one action plan
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", nullable=false, unique=true, length=11)
	public Long Id;

	
	@Column(name="name", nullable=false, unique=true, length=11)
	public String name;
	
	
	
//	@OneToMany(mappedBy = "theme", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
     
	//    private List<ActionPlan> actionplans;
	


	

	@OneToMany(mappedBy = "theme", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
		    
	    private List<ActionPlan> actionplans;
	 
	 
	 public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ActionPlan> getActionplans() {
		return actionplans;
	}

	public void setActionplans(List<ActionPlan> actionplans) {
		this.actionplans = actionplans;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@ManyToOne
	    @JoinColumn(name = "department_id")
	    private Department department;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	 
	 

}
