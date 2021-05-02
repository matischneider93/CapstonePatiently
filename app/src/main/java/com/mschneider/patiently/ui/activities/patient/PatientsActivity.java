package com.mschneider.patiently.ui.activities.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.mschneider.patiently.R;
import com.mschneider.patiently.models.Patient;
import com.mschneider.patiently.models.Physician;

import java.util.ArrayList;
import java.util.List;

public class PatientsActivity extends AppCompatActivity {
    private RecyclerView patientsRecyclerView;
    private List<Patient> patientsList = new ArrayList<>();
    private Button patientAddButton;
    private Button patientEditButton;
    private Button patientDetailButton;
    private Button patientDeleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients);
    }
}