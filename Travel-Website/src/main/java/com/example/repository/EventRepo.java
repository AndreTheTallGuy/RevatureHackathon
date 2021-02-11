package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Event;
import com.example.models.Itinerary;

public interface EventRepo extends JpaRepository<Event, Integer>{
	public List<Event> findAll();
	
	public List<Event> findByTitle(String title);
	
	public List<Event> findByDate(String date);
	
	public List<Event> findByAddress(String address);
	
	public List<Event> findByItinerary(Itinerary itinerary);
	
	public Event findByEventID(int id);
}
