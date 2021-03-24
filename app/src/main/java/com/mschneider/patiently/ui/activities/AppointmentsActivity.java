package com.mschneider.patiently.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.mschneider.patiently.R;

public class AppointmentsActivity extends AppCompatActivity {
    private ListView appointmentsListView;
    private Button appointmentAddButton;
    private Button appointmentEditButton;
    private Button appointmentDeleteButton;
    private Button appointmentDetailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);
        appointmentsListView = findViewById(R.id.appointmentsListView);
        appointmentAddButton = findViewById(R.id.appointmentAddButton);
        appointmentEditButton = findViewById(R.id.appointmentEditButton);
        appointmentDeleteButton = findViewById(R.id.appointmentDeleteButton);
        appointmentDetailButton = findViewById(R.id.appointmentDetailButton);


        appointmentAddButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(this, AppointmentAddActivity.class);
                startActivity(intent);
            }
        });

        appointmentEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this, AppointmentEditActivity.class);
                startActivity(intent);
            }
        });

        appointmentDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        appointmentDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this, AppointmentDetailActivity.class);
                startActivity(intent);
            }
        });
    }
}