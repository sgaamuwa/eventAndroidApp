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
import com.events.events.eventapplication.databinding.UserListItemBinding;
import com.events.events.eventapplication.models.User;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {

    private List<User> users;

    public UserAdapter(Context context, List<User> users){
        super(context, 0, users);
        this.users = users;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        UserListItemBinding binding;
        if(listItem == null){
            binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.user_list_item, parent, false);
            listItem = binding.getRoot();
        }else {
            binding = (UserListItemBinding) listItem.getTag();
        }
        binding.setUser(users.get(position));
        listItem.setTag(binding);
//        listItem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getContext(), EventDetailsActivity.class);
//                intent.putExtra("eventId", String.valueOf(users.get(position).get()));
//                getContext().startActivity(intent);
//            }
//        });
        return listItem;
    }
}
