package com.mschneider.patiently.ui.activities.appointment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.mschneider.patiently.R;
import com.mschneider.patiently.database.AppDatabase;
import com.mschneider.patiently.models.Appointment;
import com.mschneider.patiently.models.Physician;
import com.mschneider.patiently.ui.activities.MainActivity;
import com.mschneider.patiently.ui.activities.physician.PhysicianAddActivity;
import com.mschneider.patiently.ui.activities.physician.PhysicianEditActivity;
import com.mschneider.patiently.ui.adapters.AppointmentAdapter;
import com.mschneider.patiently.ui.adapters.PhysicianAdapter;

import java.util.ArrayList;
import java.util.List;

public class AppointmentsActivity extends AppCompatActivity implements AppointmentAdapter.ViewHolder.OnAppointmentClickListener{
    private RecyclerView appointmentsRecyclerView;
    private List<Appointment> appointmentsList = new ArrayList<>();
    private Button appointmentAddButton;
    private Button appointmentEditButton;
    private Button appointmentDetailButton;
    private Button appointmentDeleteButton;
    private int selectedPosition;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);
        AppDatabase appDatabase = MainActivity.getAppDatabase();
        List<Appointment> appointments = appDatabase.appointmentDao().getAllAppointments();
        for (Appointment appointment : appointments){ appointmentsList.add(appointment); }

        appointmentsRecyclerView = findViewById(R.id.appointmentsRecyclerView);
        appointmentsRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        appointmentsRecyclerView.setLayoutManager(layoutManager);
        appointmentsRecyclerView.setAdapter(new AppointmentAdapter(appointmentsList, this));

        // Button Connections
        appointmentAddButton = findViewById(R.id.appointmentAddButton);
        appointmentEditButton = findViewById(R.id.appointmentUpdateButton);
        appointmentDetailButton = findViewById(R.id.appointmentDetailButton);
        appointmentDeleteButton = findViewById(R.id.appointmentDeleteButton);

        appointmentAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AppointmentAddActivity.class);
                startActivity(intent);
            }
        });
        appointmentDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getAppDatabase().appointmentDao().deleteAppointment(selectedPosition);
                appointmentsList.remove(selectedPosition);
            }
        });

        appointmentEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AppointmentEditActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onAppointmentClick(int position) {
        selectedPosition = position;
        Log.d("string", String.valueOf(selectedPosition));
    }


}
