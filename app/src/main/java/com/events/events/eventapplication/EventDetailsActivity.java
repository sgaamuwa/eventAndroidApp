package com.events.events.eventapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.events.events.eventapplication.databinding.ActivityEventDetailsBinding;
import com.events.events.eventapplication.models.Event;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityEventDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_event_details);

        EventDetailsViewModel eventDetailsViewModel = ViewModelProviders.of(this).get(EventDetailsViewModel.class);
        eventDetailsViewModel.getEvent(Integer.parseInt(getIntent().getStringExtra("eventId"))).observe(this, new Observer<Event>() {
            @Override
            public void onChanged(@Nullable Event event) {
                binding.setEvent(event);
            }
        });
    }
}
