package com.mschneider.patiently.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mschneider.patiently.R;
import com.mschneider.patiently.models.Patient;
import com.mschneider.patiently.models.Physician;

import java.util.List;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.ViewHolder> {
    private int pos;
    private List<Patient> patientsList;
    private ViewHolder.OnPatientClickListener onPatientClickListener;

    public PatientAdapter(List<Patient> patients, ViewHolder.OnPatientClickListener onPatientClickListener){
        this.patientsList = patients;
        this.onPatientClickListener =  onPatientClickListener;
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView patientFirstNameTextView;
        private TextView patientLastNameTextView;
        private TextView patientEmailTextView;
        private TextView patientPhoneTextView;
        private TextView patientBloodTypeTextView;
        private TextView patientVaccinatedTextView;
        private TextView patientInsuranceProviderTextView;

        OnPatientClickListener onPatientClickListener;


        public ViewHolder(View view, OnPatientClickListener onPatientClickListener) {
            super(view);
            // Define click listener for the ViewHolder's View
            patientFirstNameTextView = view.findViewById(R.id.patientFirstNameTextView);
            patientLastNameTextView = view.findViewById(R.id.patientLastNameTextView);
            patientEmailTextView = view.findViewById(R.id.patientEmailTextView);
            patientPhoneTextView = view.findViewById(R.id.patientPhoneTextView);
            patientVaccinatedTextView = view.findViewById(R.id.patientVaccinatedTextView);
            this.onPatientClickListener = onPatientClickListener;
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onPatientClickListener.onPatientClick(getAdapterPosition());
        }

        // Click listener for row
        public interface OnPatientClickListener {
            void onPatientClick(int position);
        }


    }

    /**
     * Initialize the dataset of the Adapter.
     *
     *
     * by RecyclerView.
     * @param
     */
    public PatientAdapter(List<Patient> patients) {
        patientsList = patients;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.patient_row_item, viewGroup, false);


        return new ViewHolder(view, onPatientClickListener);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element



    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return patientsList.size();
    }


}
