package com.mschneider.patiently.ui.activities.appointment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.mschneider.patiently.R;
import com.mschneider.patiently.models.Appointment;
import com.mschneider.patiently.ui.activities.MainActivity;

import java.util.Calendar;
import java.util.Locale;

public class AppointmentAddActivity extends AppCompatActivity {
    private EditText appointmentTitleEditText;
    private EditText appointmentTypeEditText;
    private EditText appointmentDateEditText;
    private EditText appointmentTimeEditText;
    private Button appointmentAddButton; // Add button
    private Button appointmentsBackButton; // Add button
    Calendar myCalendar = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_add);
        appointmentTitleEditText = findViewById(R.id.appointmentTitleEditText);
        appointmentTypeEditText = findViewById(R.id.appointmentTypeEditText);
        appointmentDateEditText = findViewById(R.id.appointmentDateEditText);
        appointmentTimeEditText = findViewById(R.id.appointmentTimeEditText);
        appointmentAddButton = findViewById(R.id.addAppointmentButton);
        appointmentsBackButton = findViewById(R.id.backAppointmentButton); // leads to main appointment screen


        // Date and Time Mechanisms here
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };
        //TODO time mechanism


        appointmentTimeEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    Calendar mCurrentTime = Calendar.getInstance();
                    int hour = mCurrentTime.get(Calendar.HOUR_OF_DAY);
                    int minute = mCurrentTime.get(Calendar.MINUTE);
                    TimePickerDialog timePickerDialog;
                    timePickerDialog = new TimePickerDialog(AppointmentAddActivity.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                            appointmentTimeEditText.setText(selectedHour + ":" + selectedMinute);
                        }
                    }, hour, minute, true); // Allows for 24 hour view
                    timePickerDialog.setTitle("Select Time");
                    timePickerDialog.show();
                }
            }
        });




        appointmentDateEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    new DatePickerDialog(AppointmentAddActivity.this, date, myCalendar.get(Calendar.YEAR),
                            myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
            }
        });




        // vaccinated status is boolean set default as true
        appointmentAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment appointment = new Appointment(1,1,appointmentTitleEditText.getText().toString(),
                        appointmentTypeEditText.getText().toString(),appointmentDateEditText.getText().toString(), appointmentTimeEditText.getText().toString());
                MainActivity.getAppDatabase().appointmentDao().insertAppointment(appointment);
                Intent intent = new Intent(getApplicationContext(), AppointmentsActivity.class);
                startActivity(intent);
            }
        });

        appointmentsBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AppointmentsActivity.class);
                startActivity(intent);
            }
        });

    }


    private void updateLabel(){
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        appointmentDateEditText.setText(sdf.format(myCalendar.getTime()));
    }

}