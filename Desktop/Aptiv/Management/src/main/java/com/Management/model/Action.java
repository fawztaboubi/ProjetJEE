package com.Management.model;

import javax.persistence.CascadeType;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="action")
public class Action {

	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", nullable=false, unique=true, length=11)
	public int Id;
	
	@Column(name="Family",nullable=false, unique=false, length=20)
	public String Family;

	@Column(name="Project" ,nullable=false, length=20)
	public String Project ;
	
	@Column(name="Line",nullable=false, unique=false, length=20)
	public String Line;
	
	@Column(name="Manalysis",nullable=false, unique=false, length=20)
	public String Manalysis;
	
	@Column(name="RootCause",nullable=false, unique=false, length=20)
	public String RootCause;
	
	@Column(name="ActionDescription",nullable=false, unique=false, length=20)
	public String ActionDescription;
	
	@Column(name="DefectDescription",nullable=false, unique=false, length=20)
	public String DefectDescription;
	
	@Column(name="Comment",nullable=false, unique=false, length=20)
	public String Comment;
	
	@Column(name="Progress",nullable=false, unique=false, length=20)
	public String Progress;
	
	@Column(name="SecondDueDate",nullable=false, unique=false, length=20)
	public String SecondDueDate;
	
	@Column(name="ThirdDueDate",nullable=false, unique=false, length=20)
	public String ThirdDueDate;
	
	@Column(name="Responsability",nullable=false, unique=false, length=20)
	public String Responsability;
	
	@Column(name="Status", nullable=false, length=20)
	public String Status;
	
	@Column(name="Owner", nullable=false, length=20)
	public int Owner;
	
	@Column(name="StartDate", nullable=false, length=25)
	public String StartDate;
	
	@Column(name="DueDate", nullable=false, length=25)
	public String DueDate;
	
	//@OneToOne(mappedBy = "owresponse", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)
    //private OwResponse owresponse;
	
	@OneToOne(mappedBy = "action", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private OwResponse owresponse;
	
	//@OneToOne(mappedBy = "maresponse", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)
    //private MaResponse maresponse;
	
	@OneToOne(mappedBy = "action", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private MaResponse maresponse;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "theme_id", nullable = false)
    private Theme theme;
	

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public int getOwner() {
		return Owner;
	}

	public void setOwner(int owner) {
		Owner = owner;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getDueDate() {
		return DueDate;
	}

	public void setDueDate(String dueDate) {
		DueDate = dueDate;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}


}
