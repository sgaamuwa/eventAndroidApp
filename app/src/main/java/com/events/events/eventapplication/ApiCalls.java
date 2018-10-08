package com.events.events.eventapplication;

import android.util.Log;

import com.events.events.eventapplication.models.Event;
import com.events.events.eventapplication.models.User;
import com.events.events.eventapplication.rest.EventsAPIService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ApiCalls {

    private static String tag = ApiCalls.class.getName();
    private static final String BASEURL = "https://981cdbce-68d6-465c-8f08-d7e91f51c223.mock.pstmn.io";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(EventsAPIService.BASEURL)
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    private static EventsAPIService service = retrofit.create(EventsAPIService.class);

    public static List<Event> getEvents(){

        Call<List<Event>> call = service.listEvents();
        List<Event> result = null;
        try{
             result = call.execute().body();
        }catch (IOException e){
            Log.v(tag, "Had an IO Exception with the getEventsRetrofit call");
        }

        return result;
    }

    public static List<User> getUsers(){
        Call<List<User>> call = service.listUsers();
        List<User> result = null;
        try{
            result = call.execute().body();
        }catch (IOException e){
            Log.v(tag, "Had an IO Exception with the getUsers call >>> ", e);
        }

        return result;
    }

    public static Event getEvent(int eventId){
        Call<Event> call = service.listEvent(eventId);
        Event event = null;
        try{
            event = call.execute().body();
        }catch (IOException e){
            Log.v(tag, "Had an IO Exception with the getUsers call >>> ", e);
        }
        return event;
    }

}
