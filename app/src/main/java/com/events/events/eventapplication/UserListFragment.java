package com.events.events.eventapplication;

import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.events.events.eventapplication.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserListFragment extends ListFragment {
    List<User> users;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        users = new ArrayList<>();
        users.add(new User("samuel", "gaamuwa", "sgaamuwa"));
        users.add(new User("samuel", "gaamuwa", "sgaamuwa"));
        users.add(new User("samuel", "gaamuwa", "sgaamuwa"));
        users.add(new User("samuel", "gaamuwa", "sgaamuwa"));
        users.add(new User("samuel", "gaamuwa", "sgaamuwa"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        UserAdapter userAdapter = new UserAdapter(getActivity(), this.users);
        setListAdapter(userAdapter);
    }
}
