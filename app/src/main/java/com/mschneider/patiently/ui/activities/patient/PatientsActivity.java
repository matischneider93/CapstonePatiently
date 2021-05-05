package com.mschneider.patiently.ui.activities.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.mschneider.patiently.R;
import com.mschneider.patiently.database.AppDatabase;
import com.mschneider.patiently.models.Patient;
import com.mschneider.patiently.models.Physician;
import com.mschneider.patiently.ui.activities.MainActivity;
import com.mschneider.patiently.ui.activities.physician.PhysicianAddActivity;
import com.mschneider.patiently.ui.activities.physician.PhysicianDetailActivity;
import com.mschneider.patiently.ui.activities.physician.PhysicianEditActivity;
import com.mschneider.patiently.ui.adapters.PatientAdapter;
import com.mschneider.patiently.ui.adapters.PhysicianAdapter;

import java.util.ArrayList;
import java.util.List;

public class PatientsActivity extends AppCompatActivity implements PatientAdapter.ViewHolder.OnPatientClickListener {
    private RecyclerView patientsRecyclerView;
    private List<Patient> patientsList = new ArrayList<>();
    private Button patientAddButton;
    private Button patientEditButton;
    private Button patientDetailButton;
    private Button patientDeleteButton;
    private int selectedPosition;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physicians);
        AppDatabase appDatabase = MainActivity.getAppDatabase();
        List<Patient> patients = appDatabase.patientDao().getAllPatients();
        for (Patient patient : patients){ patientsList.add(patient); }

        patientsRecyclerView = findViewById(R.id.patientsRecyclerView);
        patientsRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        patientsRecyclerView.setLayoutManager(layoutManager);
        patientsRecyclerView.setAdapter(new PatientAdapter(patientsList, this));

        // Button Connections
        patientAddButton = findViewById(R.id.patientAddButton);
        patientEditButton = findViewById(R.id.patientUpdateButton);
        patientDetailButton = findViewById(R.id.patientDetailButton);
        patientDeleteButton = findViewById(R.id.physicianDeleteButton);

        patientAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PatientAddActivity.class);
                startActivity(intent);
            }
        });
        patientDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getAppDatabase().patientDao().deleteById(selectedPosition);
                patientsList.remove(selectedPosition);
                patientsRecyclerView.getAdapter().notifyDataSetChanged();

            }
        });

        patientEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PatientEditActivity.class);
                intent.putExtra("patient_first_name", patients.get(selectedPosition).getFirstName());
                intent.putExtra("physician_last_name", patients.get(selectedPosition).getLastName());
                intent.putExtra("patient_phone", patients.get(selectedPosition).getPhone());
                intent.putExtra("patient_email", patients.get(selectedPosition).getEmail());
                intent.putExtra("patient_blood_type", patients.get(selectedPosition).getBloodType());
                intent.putExtra("patient_insurance_provider", patients.get(selectedPosition).getInsuranceProvider());
                startActivity(intent);
            }
        });

        patientDetailButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PatientDetailActivity.class);
                intent.putExtra("patient_first_name", patients.get(selectedPosition).getFirstName());
                intent.putExtra("physician_last_name", patients.get(selectedPosition).getLastName());
                intent.putExtra("patient_phone", patients.get(selectedPosition).getPhone());
                intent.putExtra("patient_email", patients.get(selectedPosition).getEmail());
                intent.putExtra("patient_blood_type", patients.get(selectedPosition).getBloodType());
                intent.putExtra("patient_insurance_provider", patients.get(selectedPosition).getInsuranceProvider());
                startActivity(intent);
            }
        });

    }


    @Override
    public void onPatientClick(int position) {
        selectedPosition = position;
    }
}