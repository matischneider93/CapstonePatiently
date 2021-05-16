package com.mschneider.patiently.ui.activities.patient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.mschneider.patiently.R;

public class PatientEditActivity extends AppCompatActivity {
    private EditText patientFirstNameEditText;
    private EditText patientLastNameEditText;
    private EditText patientPhoneEditText;
    private EditText patientEmailEditText;
    private EditText patientBloodTypeEditText;
    private EditText patientVaccinatedEditText;
    private EditText patientInsuranceEditText;
    private Button patientEditButton; // Edit button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_edit);
        patientFirstNameEditText = findViewById(R.id.patientFirstNameEditText);
        patientLastNameEditText = findViewById(R.id.patientLastNameEditText);
        patientPhoneEditText = findViewById(R.id.patientPhoneEditText);
        patientEmailEditText = findViewById(R.id.patientEmailEditText);
        patientBloodTypeEditText = findViewById(R.id.patientBloodTypeEditText);
        patientInsuranceEditText = findViewById(R.id.patientInsuranceEditText);
        patientVaccinatedEditText = findViewById(R.id.patientVaccinatedEditText);
        patientEditButton = findViewById(R.id.patientUpdateButton);

        Intent intent = getIntent();
        String patientFirstName = intent.getStringExtra("patient_first_name");
        String patientLastName = intent.getStringExtra("patient_last_name");
        String patientPhone = intent.getStringExtra("patient_phone");
        String patientEmail = intent.getStringExtra("patient_email");
        String patientBloodType = intent.getStringExtra("patient_blood_type");
        String patientVaccinated = intent.getStringExtra("patient_vaccinated");
        String patientInsurance = intent.getStringExtra("patient_insurance");

        patientFirstNameEditText.setHint(patientFirstName);
        patientLastNameEditText.setHint(patientLastName);
        patientPhoneEditText.setHint(patientPhone);
        patientEmailEditText.setHint(patientEmail);
        patientBloodTypeEditText.setHint(patientBloodType);
        patientVaccinatedEditText.setHint(patientVaccinated);
        patientInsuranceEditText.setHint(patientInsurance);



        patientEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
