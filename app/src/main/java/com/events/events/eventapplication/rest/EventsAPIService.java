package com.events.events.eventapplication.rest;

import com.events.events.eventapplication.models.Event;
import com.events.events.eventapplication.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EventsAPIService {

    String BASEURL = "https://981cdbce-68d6-465c-8f08-d7e91f51c223.mock.pstmn.io/";

    @GET("events/")
    Call<List<Event>> listEvents();

    @GET("events/{event}")
    Call<Event> listEvent(@Path("event") int eventId);

    @GET("users")
    Call<List<User>> listUsers();
}
