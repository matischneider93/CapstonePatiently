package com.mschneider.patiently.ui.activities.appointment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mschneider.patiently.R;
import com.mschneider.patiently.ui.activities.physician.PhysiciansActivity;

public class AppointmentDetailActivity extends AppCompatActivity {
    private TextView appointmentTitleDetailText;
    private TextView appointmentTypeDetailText;
    private TextView appointmentDateDetailText;
    private TextView appointmentTimeDetailText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_detail);
        appointmentTitleDetailText = findViewById(R.id.appointmentTitleDetailText);
        appointmentTypeDetailText = findViewById(R.id.appointmentTypeDetailText);
        appointmentDateDetailText = findViewById(R.id.appointmentDateDetailText);
        appointmentTimeDetailText = findViewById(R.id.appointmentTimeDetailText);

        Button appointmentsBackButton = findViewById(R.id.backAppointmentsButton);

        Intent intent = getIntent();
        String appointmentTitle = intent.getStringExtra("appointment_title");
        String appointmentType = intent.getStringExtra("appointment_type");
        String appointmentDate = intent.getStringExtra("appointment_date");
        String appointmentTime = intent.getStringExtra("appointment_time");


        appointmentTitleDetailText.setText(appointmentTitle);
        appointmentTypeDetailText.setText(appointmentType);
        appointmentDateDetailText.setText(appointmentDate);
        appointmentTimeDetailText.setText(appointmentTime);

        appointmentsBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AppointmentsActivity.class);
                startActivity(intent);
            }
        });



    }
}
