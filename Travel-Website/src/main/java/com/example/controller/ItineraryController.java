package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Itinerary;
//import com.example.repository.EventRepo;
import com.example.repository.ItineraryRepo;

@RestController
@RequestMapping("/itinerary")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItineraryController {
	@Autowired
	private ItineraryRepo itineraryRepo;
	
	//private EventRepo eventRepo;
	
	@GetMapping
	public Itinerary findItineraryByUserIdAndTitle(@RequestParam String title, @RequestParam int id) {
		return itineraryRepo.findByTitleAndUserID(title, id);
	}
	
	//create by title userid
	@PostMapping
	public String createItinerary(@RequestParam String title, @RequestParam int id) {
		Itinerary itin = new Itinerary(id, title);
		System.out.println(itin);
		itineraryRepo.save(itin);
		return "New itinerary success";
	}
	
	
	@GetMapping("/allUserItinerary")
	public List<Itinerary> findAllUsersItineraries(@RequestParam int userId) {
		return itineraryRepo.findByUserID(userId);
	}
}
