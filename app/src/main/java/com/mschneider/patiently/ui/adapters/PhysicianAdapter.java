package com.mschneider.patiently.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mschneider.patiently.R;
import com.mschneider.patiently.models.Physician;

import java.util.List;


public class PhysicianAdapter extends RecyclerView.Adapter<PhysicianAdapter.PhysicianViewHolder> {

    private final LayoutInflater mInflater;
    private List<Physician> mPhysicians; // Cached copy of words

    PhysicianAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public PhysicianViewHolder onCreateViewHolder(ViewGroup parent,
                                                  int viewType) {
        View itemView = mInflater.inflate(R.layout.list_physicians, parent, false);
        return new PhysicianViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PhysicianViewHolder holder, int position) {
        if (mPhysicians != null) {
            Physician current = mPhysicians.get(position);
            holder.physicianIdTextView.setText(current.getPhysicianId());
            holder.physicianNameTextView.setText(current.getFirstName() + " " + current.getLastName());
            holder.physicianEmailTextView.setText(current.getEmail());
            holder.physicianSpecialityTextView.setText(current.getSpeciality());

        } else {
            // Covers the case of data not being ready yet.
            holder.physicianIdTextView.setText("N/A");
            holder.physicianNameTextView.setText("N/A");
            holder.physicianEmailTextView.setText("N/A");
            holder.physicianSpecialityTextView.setText("N/A");
        }
    }

    void setPhysicians(List<Physician> physicians){
        mPhysicians = physicians;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mPhysicians != null)
            return mPhysicians.size();
        else return 0;
    }

    class PhysicianViewHolder extends RecyclerView.ViewHolder {
        private final TextView physicianIdTextView;
        private final TextView physicianNameTextView;
        private final TextView physicianEmailTextView;
        private final TextView physicianSpecialityTextView;

        private PhysicianViewHolder(View itemView) {
            super(itemView);
            physicianIdTextView = itemView.findViewById(R.id.physicianIdText);
            physicianNameTextView = itemView.findViewById(R.id.physicianNameText);
            physicianEmailTextView = itemView.findViewById(R.id.physicianEmailText);
            physicianSpecialityTextView = itemView.findViewById(R.id.physicianSpecialtyText);
        }
    }
}