package com.events.events.eventapplication.models;

import java.net.URL;
import java.util.Currency;
import java.util.Date;
import java.util.List;

/**
 * Created by samuel on 23/08/2018.
 */

public class Event {

    private int eventId;
    private String title;
    private String location;
    private String description;
    private URL link;
    private Date date;
    private Currency cost;
    private User creator;
    private EventStatus eventStatus;
    private List<User> participants;

    public Event(){}

    public Event(String title, String location, String description){
        this();
        this.title = title;
        this.location = location;
        this.description = description;
    }

    public Event(String title, String location, String description, URL link, Date date, Currency cost) {
        this(title, location, description);
        this.link = link;
        this.date = date;
        this.cost = cost;
    }

    public int getEventId() {
        return eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public URL getLink() {
        return link;
    }

    public void setLink(URL link) {
        this.link = link;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Currency getCost() {
        return cost;
    }

    public void setCost(Currency cost) {
        this.cost = cost;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public EventStatus getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(EventStatus eventStatus) {
        this.eventStatus = eventStatus;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
}
