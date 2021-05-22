package com.EnicarthageClubs.model;



import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="club")
public class Club {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", nullable=false, unique=true, length=11)
	public Long Id;
	//ALTER TABLE club MODIFY
	//COLUMN Id INT auto_increment ;
	
	@Column(name="Name",nullable=false, unique=true, length=20)
	public String Name;
	
	@Column(name="Domaine",nullable=false, unique=true, length=20)
	public String Domaine;
	

	 
	 
	 @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
	 private List<Meeting> meetings;
	 
	 //One club can have many members and every member can more than one club--> manytomany with a joiningtable
	 @ManyToMany(targetEntity = Membre.class, cascade = CascadeType.ALL)
	 
	 @JoinTable(
	 
	         name="participants",
	 
	         joinColumns=
	 
	         @JoinColumn( name="club_id", referencedColumnName="Id"),
	 
	         inverseJoinColumns=@JoinColumn(name="member_id", referencedColumnName="Id"))
	 
	 private List<Membre> membres;
	 
	
	 
	//A club can host from none to many events and an event is organized by 1 or more club
     @ManyToMany(targetEntity = Event.class, cascade = CascadeType.ALL)
	 
	 @JoinTable(
	 
	         name="events",
	 
	         joinColumns=
	 
	         @JoinColumn( name="club_id", referencedColumnName="Id"),
	 
	         inverseJoinColumns=@JoinColumn(name="event_id", referencedColumnName="Id"))
	 
	 private List<Event> events;
	 
     //Club-Workshop is an [n,n] relationship-->regle3 donc manytomany
     @ManyToMany(targetEntity = Workshop.class, cascade = CascadeType.ALL)
	 
	 @JoinTable(
	 
	         name="workshops",
	 
	         joinColumns=
	 
	         @JoinColumn( name="club_id", referencedColumnName="Id"),
	 
	         inverseJoinColumns=@JoinColumn(name="workshop_id", referencedColumnName="Id"))
	 
	 private List<Workshop> workshops;
	
	  
	public List<Membre> getMembres() {
		return membres;
	}

	public void setMembres(List<Membre> membres) {
		this.membres = membres;
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

	public Club(String name, String domaine) {
		super();
		Name = name;
		Domaine = domaine;
	}

	public String getDomaine() {
		return Domaine;
	}

	public void setDomaine(String domaine) {
		Domaine = domaine;
	}

	public Club() {
		super();
	}

	
}