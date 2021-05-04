package com.mschneider.patiently.ui.activities.physician;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mschneider.patiently.R;

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
    }
}
