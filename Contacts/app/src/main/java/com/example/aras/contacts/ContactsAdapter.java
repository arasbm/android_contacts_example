package com.example.aras.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aras on 13/03/17.
 */

public class ContactsAdapter extends ArrayAdapter<Contact> {

    public ContactsAdapter(Context context, List<Contact> contacts) {
        super(context, 0, contacts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Contact contact = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_contact, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.contactName);
        TextView tvHome = (TextView) convertView.findViewById(R.id.contactNumber);
        // Populate the data into the template view using the data object
        tvName.setText(contact.getName());
        tvHome.setText(contact.getPhoneNumber());
        // Return the completed view to render on screen
        return convertView;
    }

}
