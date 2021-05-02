package com.mschneider.patiently.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mschneider.patiently.R;
import com.mschneider.patiently.database.AppDatabase;
import com.mschneider.patiently.models.Physician;
import com.mschneider.patiently.ui.activities.MainActivity;

import java.util.ArrayList;
import java.util.List;


public class PhysicianAdapter extends RecyclerView.Adapter<PhysicianAdapter.ViewHolder> {

    private List<Physician> physiciansList;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView physicianFirstNameTextView;
        private TextView physicianLastNameTextView;

        private TextView physicianSpecialtyTextView;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            physicianFirstNameTextView = view.findViewById(R.id.physicianFirstNameTextView);
            physicianLastNameTextView = view.findViewById(R.id.physicianLastNameTextView);
            physicianSpecialtyTextView = view.findViewById(R.id.physicianSpecialtyTextView);




        }

        public TextView getPhysicianFirstNameTextView() {
            return physicianFirstNameTextView;
        }
        public TextView getPhysicianLastNameTextView() {
            return physicianLastNameTextView;
        }

        public TextView getPhysicianSpecialtyTextView() {
            return physicianSpecialtyTextView;
        }


    }

    /**
     * Initialize the dataset of the Adapter.
     *
     *
     * by RecyclerView.
     * @param physicians
     */
    public PhysicianAdapter(List<Physician> physicians) {
        physiciansList = physicians;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.physician_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getPhysicianFirstNameTextView().setText(physiciansList.get(position).getFirstName());
        viewHolder.getPhysicianLastNameTextView().setText(physiciansList.get(position).getLastName());
        viewHolder.getPhysicianSpecialtyTextView().setText(physiciansList.get(position).getSpecialty());



    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return physiciansList.size();
    }
}
