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
import javax.persistence.Table;

@Entity
@Table(name="theme")

public class Theme {

	//a theme belongs to one and only one action plan
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", nullable=false, unique=true, length=11)
	public int Id;
	//many themes are linked to one action plan
	//@ManyToOne
   // @JoinColumn(name = "actionplan_id")
    //private ActionPlan actionplan;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "actionplan_id", nullable = false)
    private ActionPlan actionplan;
	
	 @OneToMany(mappedBy = "theme", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	    private List<Action> actions;
	 
	 @ManyToOne
	    @JoinColumn(name = "department_id")
	    private Department department;

}
 