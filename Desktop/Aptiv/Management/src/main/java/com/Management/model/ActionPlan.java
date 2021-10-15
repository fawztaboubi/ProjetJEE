package com.Management.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="actionplan")
public class ActionPlan {

	//an action plan is defined by an id, departments involved,and themes(VOC,VOP..)
		//still have to define the relationship manytoOne or OneToMany between and action plan and department
		
		@javax.persistence.Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		
		@Column(name="Id", nullable=false, unique=true, length=11)
		public int Id;
		
		//add a column for list of department involved
		//one action plans is linked to many themes
		//@OneToMany(mappedBy = "theme", cascade = CascadeType.ALL, orphanRemoval = true)
	   // private List<Theme> themes;
		
		 @OneToMany(mappedBy = "actionplan", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
		            
		    private List<Theme> themes;
}
