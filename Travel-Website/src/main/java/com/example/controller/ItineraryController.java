package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Itinerary;
//import com.example.repository.EventRepo;
import com.example.repository.ItineraryRepo;

@RestController
@RequestMapping("/itinerary")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItineraryController {
	private ItineraryRepo itineraryRepo;
	
	//private EventRepo eventRepo;
	
	@GetMapping
	public Itinerary findItineraryByUserIdAndTitle(String title, int id) {
		return itineraryRepo.findByTitleAndUserID(title, id);
	}
	
	//create by title userid
	@PostMapping
	public String createItinerary(String title, int id) {
		Itinerary itin = new Itinerary(id, title, null);
		itineraryRepo.save(itin);
		return "New itinerary success";
	}
	
	
	@GetMapping("/allUserItinerary")
	public List<Itinerary> findAllUsersItineraries(int userId) {
		return itineraryRepo.findByUserID(userId);
	}
}
