package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@PostMapping(path = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Response> saveItinerary(@RequestBody ItineraryForm itinForm) {
		Itinerary newItinerary = new Itinerary(itinForm.getuID(),itinForm.getTitle());
		List<Event> tempList = new ArrayList<>();
		for (EventForm event: itinForm.getEvents()) {
			Event tempEvent = new Event(event.getEventTitle(),event.getEventAddress(), event.getEventDate(), newItinerary);
			tempList.add(tempEvent);
		}
		newItinerary.setEvents(tempList);
		itineraryRepo.save(newItinerary);
		Response resp = new Response();
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}
}

