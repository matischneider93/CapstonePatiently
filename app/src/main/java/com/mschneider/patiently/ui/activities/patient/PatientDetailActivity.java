package com.mschneider.patiently.ui.activities.patient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mschneider.patiently.R;
import com.mschneider.patiently.ui.activities.patient.PatientsActivity;

public class PatientDetailActivity extends AppCompatActivity {
    private TextView patientFirstNameDetailText;
    private TextView patientLastNameDetailText;
    private TextView patientPhoneDetailText;
    private TextView patientEmailDetailText;
    private TextView patientBloodTypeDetailText;
    private TextView patientInsuranceProviderDetailText;
    private TextView patientVaccinatedDetailText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_detail);
        patientFirstNameDetailText = findViewById(R.id.patientFirstNameDetailText);
        patientLastNameDetailText = findViewById(R.id.patientLastNameDetailText);
        patientPhoneDetailText = findViewById(R.id.patientPhoneDetailText);
        patientEmailDetailText = findViewById(R.id.patientEmailDetailText);
        patientBloodTypeDetailText = findViewById(R.id.patientBloodTypeDetailText);
        patientVaccinatedDetailText = findViewById(R.id.patientVaccinatedDetailText);
        patientInsuranceProviderDetailText = findViewById(R.id.patientInsuranceDetailText);
        Button patientBackButton = findViewById(R.id.patientsBackButton);

        Intent intent = getIntent();
        String patientFirstName = intent.getStringExtra("patient_first_name");
        String patientLastName = intent.getStringExtra("patient_last_name");
        String patientPhone = intent.getStringExtra("patient_phone");
        String patientEmail = intent.getStringExtra("patient_email");
        String patientBloodType = intent.getStringExtra("patient_blood_type");
        String patientVaccinated = intent.getStringExtra("patient_vaccinated");
        String patientInsurance = intent.getStringExtra("patient_insurance");

        patientFirstNameDetailText.setText(patientFirstName);
        patientLastNameDetailText.setText(patientLastName);
        patientPhoneDetailText.setText(patientPhone);
        patientEmailDetailText.setText(patientEmail);
        patientBloodTypeDetailText.setText(patientBloodType);
        patientVaccinatedDetailText.setText(patientVaccinated);
        patientInsuranceProviderDetailText.setText(patientInsurance);

        patientBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PatientsActivity.class);
                startActivity(intent);
            }
        });



    }
}
