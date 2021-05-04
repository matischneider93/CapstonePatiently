package com.mschneider.patiently.ui.activities.physician;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.mschneider.patiently.R;
import com.mschneider.patiently.models.Physician;
import com.mschneider.patiently.ui.activities.MainActivity;

public class PhysicianEditActivity extends AppCompatActivity {
    private EditText physicianFirstNameEditText;
    private EditText physicianLastNameEditText;
    private EditText physicianPhoneEditText;
    private EditText physicianEmailEditText;
    private EditText physicianSpecialtyEditText;
    private Button physicianEditButton; // Edit button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physician_edit);
        physicianFirstNameEditText = findViewById(R.id.physicianFirstNameEditText);
        physicianLastNameEditText = findViewById(R.id.physicianLastNameEditText);
        physicianPhoneEditText = findViewById(R.id.physicianPhoneEditText);
        physicianEmailEditText = findViewById(R.id.physicianEmailEditText);
        physicianSpecialtyEditText = findViewById(R.id.physicianSpecialtyEditText);
        physicianEditButton = findViewById(R.id.physicianAddButton);
        physicianEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Physician newPhysician = new Physician(physicianFirstNameEditText.getText().toString(),
                        physicianLastNameEditText.getText().toString(),
                        physicianPhoneEditText.getText().toString(),
                        physicianEmailEditText.getText().toString(),
                        physicianSpecialtyEditText.getText().toString());
                MainActivity.getAppDatabase().physicianDao().insertPhysician(newPhysician);
                Intent intent = new Intent(getApplicationContext(), PhysiciansActivity.class);
                startActivity(intent);
            }
        });
    }
}
