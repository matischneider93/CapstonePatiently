package com.mschneider.patiently.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mschneider.patiently.R;

import java.util.ArrayList;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ViewHolder> {

    private ArrayList<String> namesList;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView firstNameTextView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            firstNameTextView = (TextView) view.findViewById(R.id.firstNameTextView);
        }

        public TextView getFirstNameTextView() {
            return firstNameTextView;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     *
     * by RecyclerView.
     */
    public ReportAdapter(ArrayList<String> firstNames) {
        namesList = firstNames;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.report_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getFirstNameTextView().setText(namesList.get(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return namesList.size();
    }
}
