package com.mschneider.patiently.ui.activities.appointment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.mschneider.patiently.R;
import com.mschneider.patiently.models.Appointment;
import com.mschneider.patiently.models.Physician;

import java.util.ArrayList;
import java.util.List;

public class AppointmentsActivity extends AppCompatActivity {
    private RecyclerView appointmentsRecyclerView;
    private List<Appointment> appointmentList = new ArrayList<>();
    private Button appointmentAddButton;
    private Button appointmentEditButton;
    private Button appointmentDetailButton;
    private Button appointmentDeleteButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);
    }
}