package com.events.events.eventapplication;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.events.events.eventapplication.databinding.EventListItemBinding;
import com.events.events.eventapplication.models.Event;

import java.util.List;

/**
 * Created by samuel on 23/08/2018.
 */

public class EventAdapter extends ArrayAdapter<Event> {

    private List<Event> events;

    public EventAdapter(Context context, List<Event> events){
        super(context, 0, events);
        this.events = events;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable final View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        EventListItemBinding binding;
        if(listItem == null){
            binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.event_list_item, parent, false);
            listItem = binding.getRoot();
        }else {
            binding = (EventListItemBinding) listItem.getTag();
        }
        binding.setEvent(events.get(position));
        listItem.setTag(binding);
        listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), EventDetailsActivity.class);
                intent.putExtra("eventId", String.valueOf(events.get(position).getEventId()));
                getContext().startActivity(intent);
            }
        });
        return listItem;
    }
}
