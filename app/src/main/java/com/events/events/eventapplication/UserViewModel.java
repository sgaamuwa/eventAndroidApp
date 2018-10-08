package com.events.events.eventapplication;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.events.events.eventapplication.models.User;

import java.util.List;

public class UserViewModel extends ViewModel {

    private MutableLiveData<List<User>> userLiveData;

    public LiveData<List<User>> getUsers(){
        if(userLiveData == null){
            userLiveData = new MutableLiveData<>();
            loadUsers();
        }
        return userLiveData;
    }

    public void loadUsers(){
        UserViewAsyncTask userViewAsyncTask = new UserViewAsyncTask();
        userViewAsyncTask.execute();
    }

    private class UserViewAsyncTask extends AsyncTask<Void, Void, List<User>>{
        @Override
        protected List<User> doInBackground(Void... voids) {
            return ApiCalls.getUsers();
        }

        @Override
        protected void onPostExecute(List<User> users) {
            super.onPostExecute(users);
            userLiveData.setValue(users);
        }
    }
}
