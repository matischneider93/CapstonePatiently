package com.mschneider.patiently.ui.activities.patient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.mschneider.patiently.R;
import com.mschneider.patiently.models.Patient;
import com.mschneider.patiently.ui.activities.MainActivity;

public class PatientAddActivity extends AppCompatActivity {
    private EditText patientFirstNameEditText;
    private EditText patientLastNameEditText;
    private EditText patientPhoneEditText;
    private EditText patientEmailEditText;
    private EditText patientVaccinatedEditText;
    private EditText patientInsuranceEditText;
    private EditText patientBloodTypeEditText;
    private Button patientAddButton; // Add button
    private Button patientsBackButton; // Add button


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_add);
        patientFirstNameEditText = findViewById(R.id.patientFirstNameEditText);
        patientLastNameEditText = findViewById(R.id.patientLastNameEditText);
        patientPhoneEditText = findViewById(R.id.patientPhoneEditText);
        patientEmailEditText = findViewById(R.id.patientEmailEditText);
        patientInsuranceEditText = findViewById(R.id.patientInsuranceEditText);
        patientVaccinatedEditText = findViewById(R.id.patientVaccinatedEditText);
        patientBloodTypeEditText = findViewById(R.id.patientBloodTypeEditText);
        patientAddButton = findViewById(R.id.addPatientButton);
        patientsBackButton = findViewById(R.id.patientsBackButton); // leads to main patient screen




        // vaccinated status is boolean set default as true
        patientAddButton.setOnClickListener(new View.OnClickListener() {

            boolean vaccinatedBoolean;
            @Override
            public void onClick(View v) {
                if (patientVaccinatedEditText.getText().toString().contains("yes")){
                    vaccinatedBoolean = true;
                } else {
                    vaccinatedBoolean = false;
                }
                patientVaccinatedEditText.getText().toString();
                Patient newPatient = new Patient(1, patientFirstNameEditText.getText().toString(),
                        patientLastNameEditText.getText().toString(),patientEmailEditText.getText().toString(), patientPhoneEditText.getText().toString(), patientBloodTypeEditText.getText().toString(), vaccinatedBoolean, patientInsuranceEditText.getText().toString());
                MainActivity.getAppDatabase().patientDao().insertPatient(newPatient);
                Intent intent = new Intent(getApplicationContext(), PatientsActivity.class);
                startActivity(intent);
            }
        });

        patientsBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PatientsActivity.class);
                startActivity(intent);
            }
        });

    }


}