package com.example.models;

import java.util.List;

public class ItineraryForm {
    private int uID;
    private String title;
    private EventForm[] events;

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EventForm[] getEvents() {
        return events;
    }

    public void setEvents(EventForm[] events) {
        this.events = events;
    }
}
