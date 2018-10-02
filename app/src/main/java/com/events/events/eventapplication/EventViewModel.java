package com.events.events.eventapplication;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.events.events.eventapplication.models.Event;

import java.util.List;

public class EventViewModel extends ViewModel {

    private MutableLiveData<List<Event>> eventLiveData;

    public LiveData<List<Event>> getEvents(){
        if(eventLiveData == null){
            eventLiveData = new MutableLiveData<>();
            loadEvents();
        }

        return eventLiveData;
    }

    public void loadEvents(){
        EventAsyncTask eventAsyncTask = new EventAsyncTask();
        eventAsyncTask.execute();
    }

    private class EventAsyncTask extends AsyncTask<Void, Void, List<Event>>{
        @Override
        protected List<Event> doInBackground(Void... voids) {
            return ApiCalls.getEvents();
        }

        @Override
        protected void onPostExecute(List<Event> events) {
            super.onPostExecute(events);
            eventLiveData.setValue(events);
        }
    }

}
