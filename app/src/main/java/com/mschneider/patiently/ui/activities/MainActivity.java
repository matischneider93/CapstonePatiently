package com.mschneider.patiently.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mschneider.patiently.R;
import com.mschneider.patiently.database.AppDatabase;
import com.mschneider.patiently.database.view_models.PhysicianViewModel;
import com.mschneider.patiently.models.Patient;
import com.mschneider.patiently.models.Physician;
import com.mschneider.patiently.ui.activities.appointment.AppointmentsActivity;
import com.mschneider.patiently.ui.activities.patient.PatientsActivity;
import com.mschneider.patiently.ui.activities.physician.PhysiciansActivity;
import com.mschneider.patiently.ui.activities.reports.ReportsActivity;
import com.mschneider.patiently.ui.adapters.PhysicianAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public static AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button physiciansButton, patientsButton, appointmentsButton, reportsButton;
        physiciansButton = (Button) findViewById(R.id.physiciansButton);
        patientsButton = (Button) findViewById(R.id.patientsButton);
        appointmentsButton = (Button) findViewById(R.id.appointmentsButton);
        reportsButton = (Button) findViewById(R.id.reportsButton);

        // when upgrading versions, kill the original tables by using fallbackToDestructiveMigration()
        appDatabase = AppDatabase.getDatabaseInstance(getApplicationContext());
        Patient newPatient = new Patient(1, "Sharon", "Baba", "sharonbaba@gmail.com", "6178787", "O", true, "BlueCross");
        appDatabase.patientDao().insertPatient(newPatient);















        physiciansButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PhysiciansActivity.class);
                startActivity(intent);
            }
        });

        patientsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PatientsActivity.class);
                startActivity(intent);
            }
        });
        appointmentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AppointmentsActivity.class);
                startActivity(intent);
            }
        });
        reportsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReportsActivity.class);
                startActivity(intent);
            }
        });
    }


    // Function to clear app database entries
    private void clearAppDatabases() {
        appDatabase.appointmentDao().deleteAllAppointments();
        appDatabase.patientDao().deleteAllPatients();
        appDatabase.physicianDao().deleteAllPhysicians();
    }

    public static AppDatabase getAppDatabase() {
        return appDatabase;
    }

}
