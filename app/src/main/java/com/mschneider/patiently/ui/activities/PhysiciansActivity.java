package com.mschneider.patiently.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.mschneider.patiently.R;

public class PhysiciansActivity extends AppCompatActivity {
    private ListView physiciansListView;
    private Button physicianAddButton;
    private Button physicianEditButton;
    private Button physicianDeleteButton;
    private Button physicianDetailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        physiciansListView = findViewById(R.id.physiciansListView);
        physicianAddButton = findViewById(R.id.physicianAddButton);
        physicianEditButton = findViewById(R.id.physicianEditButton);
        physicianDeleteButton = findViewById(R.id.physicianDeleteButton);
        physicianDetailButton = findViewById(R.id.physicianDetailButton);
        setContentView(R.layout.activity_physicians);


        physicianAddButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(this, PhysicianAddActivity.class);
                startActivity(intent);
            }
        });

        physicianEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this, PhysicianEditActivity.class);
                startActivity(intent);
            }
        });

        physicianDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        physicianDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this, PhysicianDetailActivity.class);
                startActivity(intent);
            }
        });


        
    }



}