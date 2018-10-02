package com.events.events.eventapplication;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.events.events.eventapplication.databinding.ActivityEventDetailsBinding;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityEventDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_event_details);
        binding.setEvent(getIntent().getStringExtra("eventId"));
    }
}
