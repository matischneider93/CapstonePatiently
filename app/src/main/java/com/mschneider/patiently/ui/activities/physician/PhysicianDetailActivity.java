package com.mschneider.patiently.ui.activities.physician;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mschneider.patiently.R;
import com.mschneider.patiently.models.Physician;
import com.mschneider.patiently.ui.activities.MainActivity;

public class PhysicianDetailActivity extends AppCompatActivity {
    private TextView physicianFirstNameDetailText;
    private TextView physicianLastNameDetailText;
    private TextView physicianPhoneDetailText;
    private TextView physicianEmailDetailText;
    private TextView physicianSpecialtyDetailText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physician_detail);
        physicianFirstNameDetailText = findViewById(R.id.physicianFirstNamedetailText);
        physicianLastNameDetailText = findViewById(R.id.physicianLastNameDetailText);
        physicianPhoneDetailText = findViewById(R.id.physicianPhoneDetailText);
        physicianEmailDetailText = findViewById(R.id.physicianEmailDetailText);
        physicianSpecialtyDetailText = findViewById(R.id.physicianSpecialtyDetailText);
        Button physicianBackButton = findViewById(R.id.physicianBackButton);

        Intent intent = getIntent();
        String physicianFirstName = intent.getStringExtra("physician_first_name");
        String physicianLastName = intent.getStringExtra("physician_last_name");
        String physicianPhone = intent.getStringExtra("physician_phone");
        String physicianEmail = intent.getStringExtra("physician_email");
        String physicianSpecialty = intent.getStringExtra("physician_specialty");

        physicianFirstNameDetailText.setText(physicianFirstName);
        physicianLastNameDetailText.setText(physicianLastName);
        physicianPhoneDetailText.setText(physicianPhone);
        physicianEmailDetailText.setText(physicianEmail);
        physicianSpecialtyDetailText.setText(physicianSpecialty);

        physicianBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PhysiciansActivity.class);
                startActivity(intent);
            }
        });



    }
}
