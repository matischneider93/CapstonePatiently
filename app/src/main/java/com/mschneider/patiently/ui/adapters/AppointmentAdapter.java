package com.mschneider.patiently.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mschneider.patiently.R;
import com.mschneider.patiently.models.Appointment;
import com.mschneider.patiently.models.Physician;

import java.util.List;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.ViewHolder> {
    private int pos;
    private List<Appointment> appointmentsList;
    private AppointmentAdapter.ViewHolder.OnAppointmentClickListener onAppointmentClickListener;

    public AppointmentAdapter(List<Appointment> appointments, AppointmentAdapter.ViewHolder.OnAppointmentClickListener onAppointmentClickListener){
        this.appointmentsList = appointments;
        this.onAppointmentClickListener =  onAppointmentClickListener;
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView appointmentTitleTextView;
        private TextView appointmentTypeTextView;
        private TextView appointmentTimeTextView;
        private TextView appointmentDateTextView;

        AppointmentAdapter.ViewHolder.OnAppointmentClickListener onAppointmentClickListener;


        public ViewHolder(View view, AppointmentAdapter.ViewHolder.OnAppointmentClickListener onAppointmentClickListener) {
            super(view);
            // Define click listener for the ViewHolder's View
            appointmentTitleTextView = view.findViewById(R.id.appointmentTitleTextView);
            appointmentTypeTextView = view.findViewById(R.id.appointmentTypeTextView);
            appointmentTimeTextView = view.findViewById(R.id.appointmentTimeTextView);
            appointmentDateTextView = view.findViewById(R.id.appointmentDateTextView);
            this.onAppointmentClickListener = onAppointmentClickListener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onAppointmentClickListener.onAppointmentClick(getAdapterPosition());
        }

        // Click listener for row
        public interface OnAppointmentClickListener {
            void onAppointmentClick(int position);
        }


    }

    /**
     * Initialize the dataset of the Adapter.
     *
     *
     * by RecyclerView.
     * @param
     */
    public AppointmentAdapter(List<Appointment> appointments) {
        appointmentsList = appointments;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public AppointmentAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.appointment_row_item, viewGroup, false);


        return new AppointmentAdapter.ViewHolder(view, onAppointmentClickListener);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(AppointmentAdapter.ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element





    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return appointmentsList.size();
    }
}
