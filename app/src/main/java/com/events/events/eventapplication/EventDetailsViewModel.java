package com.events.events.eventapplication;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.events.events.eventapplication.models.Event;

public class EventDetailsViewModel extends ViewModel {

    private MutableLiveData<Event> eventLiveData;

    public LiveData<Event> getEvent(int eventId){
        if(eventLiveData == null){
            eventLiveData = new MutableLiveData<>();
            loadEvent(eventId);
        }

        return eventLiveData;
    }

    public void loadEvent(int eventId){
        EventAsyncTask eventAsyncTask = new EventAsyncTask();
        eventAsyncTask.execute(eventId);
    }

    private class EventAsyncTask extends AsyncTask<Integer, Void, Event> {
        @Override
        protected Event doInBackground(Integer... eventId) {
            return ApiCalls.getEvent(eventId[0]);
        }

        @Override
        protected void onPostExecute(Event event) {
            super.onPostExecute(event);
            eventLiveData.setValue(event);
        }
    }
}
