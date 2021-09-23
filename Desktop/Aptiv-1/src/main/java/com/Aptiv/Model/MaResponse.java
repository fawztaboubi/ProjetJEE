package com.Aptiv.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="maresponse")
public class MaResponse {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", nullable=false, unique=true, length=11)
	public Long Id;

	
	@Column(name="NewDueDate",nullable=false, unique=false, length=20)
	public String NewDueDate;
	
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "action_id", nullable = false)
    private Action action;


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public Action getAction() {
		return action;
	}


	public void setAction(Action action) {
		this.action = action;
	}


	public String getNewDueDate() {
		return NewDueDate;
	}


	public void setNewDueDate(String newDueDate) {
		NewDueDate = newDueDate;
	}

	
}
