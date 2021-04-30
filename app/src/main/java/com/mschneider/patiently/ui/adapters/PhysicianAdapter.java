package com.mschneider.patiently.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mschneider.patiently.R;
import com.mschneider.patiently.database.repo.PhysicianRepo;
import com.mschneider.patiently.database.view_models.PhysicianViewModel;
import com.mschneider.patiently.models.Physician;

import java.util.ArrayList;
import java.util.List;


public class PhysicianAdapter extends ArrayAdapter<Physician> {
    public PhysicianAdapter(Context context, ArrayList<Physician> physicians) {
        super(context, 0, physicians);


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Physician physician = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_physician, parent, false);

        }
        // Lookup view for data population
        TextView physicianIdTextView = (TextView) convertView.findViewById(R.id.physicianNameTextView);
        TextView physicianNameTextView = (TextView) convertView.findViewById(R.id.physicianNameTextView);
        // Populate the data into the template view using the data object
        physicianIdTextView.setText(physician.physicianId);
        physicianNameTextView.setText(physician.firstName + " " + physician.lastName);
        // Return the completed view to render on screen
        return convertView;
    }
}

