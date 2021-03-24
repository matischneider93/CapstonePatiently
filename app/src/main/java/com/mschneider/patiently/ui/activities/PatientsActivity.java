package com.mschneider.patiently.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.mschneider.patiently.R;

public class PatientsActivity extends AppCompatActivity {
    private ListView patientsListView;
    private Button patientAddButton;
    private Button patientEditButton;
    private Button patientDeleteButton;
    private Button patientDetailButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients);
        patientsListView = findViewById(R.id.patientsListView);
        patientAddButton = findViewById(R.id.patientAddButton);
        patientEditButton = findViewById(R.id.patientEditButton);
        patientDeleteButton = findViewById(R.id.patientEditButton);
        patientDetailButton = findViewById(R.id.patientDetailButton);


        patientAddButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(this, PatientAddActivity.class);
                startActivity(intent);
            }
        });

        patientEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this, PatientEditActivity.class);
                startActivity(intent);
            }
        });

        patientDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        patientDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this, PatientDetailActivity.class);
                startActivity(intent);
            }
        });

    }


}