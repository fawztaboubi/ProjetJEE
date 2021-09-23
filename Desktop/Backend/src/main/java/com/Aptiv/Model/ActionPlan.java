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
@Table(name="actionplan")
public class ActionPlan implements Serializable{

	//an action plan is defined by an id, departments involved,and themes(VOC,VOP..)
		//still have to define the relationship manytoOne or OneToMany between and action plan and department
		
		@javax.persistence.Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="Id", nullable=false, unique=true, length=11)
		public Long Id;
		
		@Column(name="Name", nullable=false, unique=false, length=50)
		public String Name;
		
				
		@OneToMany(mappedBy = "actionplan", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	    private List<Action> actions;
		 
	 

		public List<Action> getActions() {
			return actions;
		}

		public void setActions(List<Action> actions) {
			this.actions = actions;
		}



		public void setTheme(Theme theme) {
			this.theme = theme;
		}

		@ManyToOne(fetch = FetchType.LAZY, optional = false)
		@JoinColumn(name = "theme_id", nullable = false)
		    private Theme theme;

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
		 
}
