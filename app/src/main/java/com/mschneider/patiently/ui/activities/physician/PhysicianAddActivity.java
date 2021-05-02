package com.mschneider.patiently.ui.activities.physician;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.mschneider.patiently.R;

public class PhysicianAddActivity extends AppCompatActivity {
    private EditText physicianFirstNameEditText;
    private EditText physicianLastNameEditText;
    private EditText physicianPhoneEditText;
    private EditText physicianEmailEditText;
    private EditText physicianSpecialtyEditText;
    private Button physicianUpdateButton; // Add button


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physician_add);
        physicianFirstNameEditText = findViewById(R.id.physicianFirstNameEditText);
        physicianLastNameEditText = findViewById(R.id.physicianLastNameEditText);
        physicianPhoneEditText = findViewById(R.id.physicianPhoneEditText);
        physicianEmailEditText = findViewById(R.id.physicianPhoneEditText);
        physicianSpecialtyEditText = findViewById(R.id.physicianPhoneEditText);
        physicianUpdateButton = findViewById(R.id.physicianUpdateButton);

    }
}
