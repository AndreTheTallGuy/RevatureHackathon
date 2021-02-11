package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Itinerary;

public interface ItineraryRepo extends JpaRepository<Itinerary, Integer>{
	public List<Itinerary> findAll();
	
	public Itinerary findById(int itineraryId);
	
	public List<Itinerary> findByUserID(int userId);
	
	public Itinerary findByTitle(String title);
	
	public Itinerary findByTitleAndUserID(String title, int userID);
}
