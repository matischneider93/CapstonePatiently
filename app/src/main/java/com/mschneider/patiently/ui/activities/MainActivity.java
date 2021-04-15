package com.mschneider.patiently.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mschneider.patiently.R;
import com.mschneider.patiently.database.AppDatabase;
import com.mschneider.patiently.ui.activities.appointment.AppointmentsActivity;
import com.mschneider.patiently.ui.activities.patient.PatientsActivity;
import com.mschneider.patiently.ui.activities.physician.PhysiciansActivity;

public class MainActivity extends AppCompatActivity {

   public static AppDatabase appDatabase;
   private Button physiciansButton, patientsButton, appointmentsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        physiciansButton = (Button) findViewById(R.id.physiciansButton);
        patientsButton = (Button) findViewById(R.id.patientsButton);
        appointmentsButton = (Button) findViewById(R.id.appointmentsButton);

        // when upgrading versions, kill the original tables by using fallbackToDestructiveMigration()
        appDatabase = Room.databaseBuilder(this, AppDatabase.class,
                AppDatabase.DATABASE_NAME).allowMainThreadQueries().build();

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
            Intent intent = new Intent(MainActivity.this, PhysiciansActivity.class);
            startActivity(intent);
        }
    public void openPatientsActivity(){
        Intent intent = new Intent(MainActivity.this, PatientsActivity.class);
        startActivity(intent);
    }
    public void openAppointmentsActivity() {
        Intent intent = new Intent(this, AppointmentsActivity.class);
    }


}
