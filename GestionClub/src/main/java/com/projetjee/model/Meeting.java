package com.projetjee.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Meeting implements Activity {

	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", nullable=false, unique=true, length=11)
	public Long Id;
	
	@Column(name="Topic",nullable=false, unique=true, length=20)
	public String topic;
	
	@Column(name="Moderator",nullable=false, unique=true, length=20)
	public String moderator;
	
	@Column(name="Office",nullable=false, unique=true, length=20)
	public String Office;
	
	
	@ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;


	public Meeting(String topic, String moderator, String office, Club club) {
		super();
		this.topic = topic;
		this.moderator = moderator;
		Office = office;
		this.club = club;
	}


	public Meeting() {
		super();
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getTopic() {
		return topic;
	}


	public void setTopic(String topic) {
		this.topic = topic;
	}


	public String getModerator() {
		return moderator;
	}


	public void setModerator(String moderator) {
		this.moderator = moderator;
	}


	public String getOffice() {
		return Office;
	}


	public void setOffice(String office) {
		Office = office;
	}


	public Club getClub() {
		return club;
	}


	public void setClub(Club club) {
		this.club = club;
	}





}
