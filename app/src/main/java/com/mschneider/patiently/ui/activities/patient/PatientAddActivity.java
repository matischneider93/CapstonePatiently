package com.mschneider.patiently.ui.activities.patient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.mschneider.patiently.R;
import com.mschneider.patiently.models.Patient;
import com.mschneider.patiently.models.Physician;
import com.mschneider.patiently.ui.activities.MainActivity;
import com.mschneider.patiently.ui.activities.physician.PhysiciansActivity;

public class PatientAddActivity extends AppCompatActivity {
    private EditText patientFirstNameEditText;
    private EditText patientLastNameEditText;
    private EditText patientPhoneEditText;
    private EditText patientEmailEditText;
    private EditText patientVaccinatedEditText;
    private EditText patientInsuranceEditText;
    private EditText patientBloodTypeEditText;
    private Button patientUpdateButton; // Add button


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
        patientUpdateButton = findViewById(R.id.patientUpdateButton);




        // vaccinated status is boolean set default as true
        patientUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Patient newPatient = new Patient(2, patientFirstNameEditText.getText().toString(),
                        patientLastNameEditText.getText().toString(),patientEmailEditText.getText().toString(), patientPhoneEditText.getText().toString(), patientBloodTypeEditText.getText().toString(), true, patientInsuranceEditText.getText().toString());
                MainActivity.getAppDatabase().patientDao().insertPatient(newPatient);
                Intent intent = new Intent(getApplicationContext(), PatientsActivity.class);
                startActivity(intent);
            }
        });

    }
}