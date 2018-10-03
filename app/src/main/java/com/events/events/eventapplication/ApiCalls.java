package com.events.events.eventapplication;

import android.util.Log;

import com.events.events.eventapplication.models.Event;
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

public class ApiCalls {

    private static String tag = ApiCalls.class.getName();
    private static final String BASEURL = "https://981cdbce-68d6-465c-8f08-d7e91f51c223.mock.pstmn.io";

    public static List<Event> getEvents(){
        List<Event> events = null;
        try{
            URL url = new URL(String.format("%s/events", BASEURL));
            // create an URL connection to make the call
            HttpURLConnection urlConnection = (HttpURLConnection) makeAPICall(url, "GET");
            // convert response to JSON
            String responseJSON = readResponseToString(urlConnection.getInputStream());
            ObjectMapper objectMapper = new ObjectMapper();

            events = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(responseJSON);
            for(int counter = 0; counter < jsonArray.length(); counter ++){
                JSONObject jsonObject = (JSONObject) jsonArray.get(counter);
                // map each JSONObject into an event
                Event event = objectMapper.readValue(jsonObject.toString(), Event.class);
                events.add(event);
            }

            // close the urlConnection if it exists
            if(urlConnection != null){
                urlConnection.disconnect();
            }

        }catch (MalformedURLException e){
            Log.v(tag, "Error creating the URL from the provided string >>>>"+e.toString());
        }catch (IOException e){
            Log.v(tag, e.toString());
        }catch (JSONException e){
            Log.v(tag, "Error mapping the JSON into an event object >>>>"+e.toString());
        }

        return events;
    }

    public static Event getEvent(int eventId){
        Event event = null;
        try{
            URL url = new URL(String.format("%s/events/%d",BASEURL, eventId));
            // create an URL connection to make the call
            HttpURLConnection urlConnection = (HttpURLConnection) makeAPICall(url, "GET");
            // convert response to JSON
            String responseJSON = readResponseToString(urlConnection.getInputStream());
            ObjectMapper objectMapper = new ObjectMapper();
            JSONObject jsonObject = new JSONObject(responseJSON);
            String jsonString = jsonObject.toString();
            event = objectMapper.readValue(jsonObject.toString(), Event.class);

            // close the urlConnection if it exists
            if(urlConnection != null){
                urlConnection.disconnect();
            }

        }catch (MalformedURLException e){
            Log.v(tag, "Error creating the URL from the provided string >>>>"+e.toString());
        }catch (IOException e){
            Log.v(tag, e.toString());
        }catch (JSONException e){
            Log.v(tag, "Error mapping the JSON into an event object >>>>"+e.toString());
        }

        return event;
    }

    private static String readResponseToString(InputStream inputStream){
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))){
            String line = bufferedReader.readLine();
            while (line != null){
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }
        }catch (IOException e){
            Log.v(tag, "Error reading the response to string >>>>"+e.toString());
        }

        return stringBuilder.toString();
    }

    private static URLConnection makeAPICall(URL url, String callMethod){
        HttpURLConnection urlConnection = null;
        try{
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod(callMethod);
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.connect();
        }catch (ProtocolException e){
            Log.v(tag, "Error making API call"+e.toString());
        }catch (IOException e){
            Log.v(tag, "Error making API call"+e.toString());
        }
        return urlConnection;
    }

}
