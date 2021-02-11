package com.example.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="itinerary")
public class Itinerary {
	
	@Id
	@Column(name="itinerary_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="user_id")
	private int userID;
	
	@Column(name="title", unique=true)
	private String title;
	
	@OneToMany(mappedBy="itinerary")
	private List<Event> events = new ArrayList<>();
	
	public Itinerary() {
		// TODO Auto-generated constructor stub
	}

	

	public Itinerary(int id, int userID, String title, List<Event> events) {
		super();
		this.id = id;
		this.userID = userID;
		this.title = title;
		this.events = events;
	}

	public Itinerary(int userID, String title) {
		super();
		this.userID = userID;
		this.title = title;
	}
	
	public Itinerary(int userID, String title, List<Event> events) {
		super();
		this.userID = userID;
		this.title = title;
		this.events = events;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Itinerary [id=" + id + ", userID=" + userID + ", title=" + title + "]";
	}
}
