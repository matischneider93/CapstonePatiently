package com.mschneider.patiently.ui.activities.appointment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.mschneider.patiently.R;
import com.mschneider.patiently.models.Appointment;
import com.mschneider.patiently.models.Physician;
import com.mschneider.patiently.ui.activities.MainActivity;
import com.mschneider.patiently.ui.activities.physician.PhysiciansActivity;

public class AppointmentEditActivity extends AppCompatActivity {
    private EditText appointmentTitleEditText;
    private EditText appointmentTypeEditText;
    private EditText appointmentDateEditText;
    private EditText appointmentTimeEditText;

    private Button appointmentEditButton; // Edit button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_edit);
        appointmentTitleEditText = findViewById(R.id.appointmentTitleEditText);
        appointmentTypeEditText = findViewById(R.id.appointmentTypeEditText);
        appointmentDateEditText = findViewById(R.id.appointmentDateEditText);
        appointmentTimeEditText = findViewById(R.id.appointmentTimeEditText);
        appointmentEditButton = findViewById(R.id.appointmentEditButton);

        Intent intent = getIntent();
        String appointmentTitle = intent.getStringExtra("appointment_title");
        String appointmentType = intent.getStringExtra("appointment_type");
        String appointmentDate = intent.getStringExtra("appointment_date");
        String appointmentTime = intent.getStringExtra("appointment_time");

        appointmentTitleEditText.setHint(appointmentTitle);
        appointmentTypeEditText.setHint(appointmentType);
        appointmentDateEditText.setHint(appointmentDate);
        appointmentTimeEditText.setText(appointmentTime);


        appointmentEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (appointmentTitleEditText.getText().toString().isEmpty()){ appointmentTitleEditText.setText(appointmentTitle); }
                if (appointmentTypeEditText.getText().toString().isEmpty()){ appointmentTypeEditText.setText(appointmentType); }
                if (appointmentDateEditText.getText().toString().isEmpty()){ appointmentDateEditText.setText(appointmentDate); }
                if (appointmentTimeEditText.getText().toString().isEmpty()){ appointmentTimeEditText.setText(appointmentTime); }
                Appointment updatedAppointment = new Appointment(1,1, appointmentTitleEditText.getText().toString(),
                        appointmentTypeEditText.getText().toString(),
                        appointmentDateEditText.getText().toString(),
                        appointmentTimeEditText.getText().toString()
                        );
                MainActivity.getAppDatabase().appointmentDao().updateAppointment(updatedAppointment);
                Intent intent = new Intent(getApplicationContext(), AppointmentsActivity.class);
                startActivity(intent);
            }
        });
    }
}
