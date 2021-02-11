package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="event")
public class Event {
	
	@Id
	@Column(name="event_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eventID; 
	
	@Column(name="title")
	private String title;
	
	@Column(name="address")
	private String address;
	
	@Column(name="date")
	private String date;
	
	@ManyToOne
	@JoinColumn(name="itinerary_id", nullable=false)
	@JsonIgnore
	private Itinerary itinerary;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}

	

	public Event(String title, String address, String date, Itinerary itinerary) {
		super();
		this.title = title;
		this.address = address;
		this.date = date;
		this.itinerary = itinerary;
	}



	public Event(int eventID, String title, String address, String date, Itinerary itinerary) {
		super();
		this.eventID = eventID;
		this.title = title;
		this.address = address;
		this.date = date;
		this.itinerary = itinerary;
	}

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}



	public Itinerary getItinerary() {
		return itinerary;
	}



	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}



	@Override
	public String toString() {
		return "Event [eventID=" + eventID + ", title=" + title + ", address=" + address + ", date=" + date
				+ ", itinerary=" + itinerary + "]";
	}
}
