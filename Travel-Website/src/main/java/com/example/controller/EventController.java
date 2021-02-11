package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Event;
import com.example.models.Itinerary;
import com.example.repository.EventRepo;
import com.example.repository.ItineraryRepo;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventController {
	private ItineraryRepo itineraryRepo;

	private EventRepo eventRepo;
	
	@GetMapping
	public List<Event> findEventsFromItinerary(int userID, String title) {
		Itinerary itin = itineraryRepo.findByTitleAndUserID(title, userID);
		return itin.getEvents();
	}
	
	@PostMapping
	public String createEvent(String title, String address, String date, String itinTitle) {
		Itinerary itin = itineraryRepo.findByTitle(itinTitle);
		Event event = new Event(title, address, date, itin);
		//itin.getEvents().add(event);
		eventRepo.save(event);
//		itineraryRepo.save(itin);
		return "success";
	}
}
