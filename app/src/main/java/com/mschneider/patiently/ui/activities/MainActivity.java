package com.mschneider.patiently.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mschneider.patiently.R;

public class MainActivity extends AppCompatActivity {
    private Button physiciansButton;
    private Button patientsButton;
    private Button appointmentsButton;

    private boolean loggedIn = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        physiciansButton = findViewById(R.id.physiciansButton);
        patientsButton = findViewById(R.id.patientsButton);
        appointmentsButton = findViewById(R.id.appointmentsButton);

        physiciansButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPhysiciansActivity();
            }
        });
        patientsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPatientsActivity();
            }
        });
        appointmentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAppointmentsActivity();
            }
        });

    }

    // Button Functions for Screens
    public void openPhysiciansActivity(){
            Intent intent = new Intent(this, PhysiciansActivity.class);
            startActivity(intent);
        }
    public void openPatientsActivity(){
        Intent intent = new Intent(this, PatientsActivity.class);
        startActivity(intent);
    }
    public void openAppointmentsActivity() {
        Intent intent = new Intent(this, AppointmentsActivity.class);
    }
}
