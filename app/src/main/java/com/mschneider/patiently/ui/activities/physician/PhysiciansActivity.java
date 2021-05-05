package com.mschneider.patiently.ui.activities.physician;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mschneider.patiently.R;
import com.mschneider.patiently.database.AppDatabase;
import com.mschneider.patiently.models.Physician;
import com.mschneider.patiently.ui.activities.MainActivity;
import com.mschneider.patiently.ui.adapters.PhysicianAdapter;

import java.util.ArrayList;
import java.util.List;

public class PhysiciansActivity extends AppCompatActivity implements PhysicianAdapter.ViewHolder.OnPhysicianClickListener {
    private RecyclerView physiciansRecyclerView;
    private List<Physician> physiciansList = new ArrayList<>();
    private Button physicianAddButton;
    private Button physicianEditButton;
    private Button physicianDetailButton;
    private Button physicianDeleteButton;
    private int selectedPosition;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_physicians);
            AppDatabase appDatabase = MainActivity.getAppDatabase();
            List<Physician> physicians = appDatabase.physicianDao().getAllPhysicians();
            for (Physician physician : physicians){ physiciansList.add(physician); }

            physiciansRecyclerView = findViewById(R.id.physiciansRecyclerView);
            physiciansRecyclerView.setHasFixedSize(true);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            physiciansRecyclerView.setLayoutManager(layoutManager);
            physiciansRecyclerView.setAdapter(new PhysicianAdapter(physiciansList, this));

            // Button Connections
            physicianAddButton = findViewById(R.id.physicianEditButton);
            physicianEditButton = findViewById(R.id.physiciansUpdateButton);
            physicianDetailButton = findViewById(R.id.physicianDetailButton);
            physicianDeleteButton = findViewById(R.id.physicianDeleteButton);

            physicianAddButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), PhysicianAddActivity.class);
                    startActivity(intent);
                }
            });
            physicianDeleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  MainActivity.getAppDatabase().physicianDao().deleteById(selectedPosition);
                  physiciansList.remove(selectedPosition);
                  physiciansRecyclerView.getAdapter().notifyDataSetChanged();

                }
            });

        physicianEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PhysicianEditActivity.class);
                intent.putExtra("physician_first_name", physicians.get(selectedPosition).getFirstName());
                intent.putExtra("physician_last_name", physicians.get(selectedPosition).getLastName());
                intent.putExtra("physician_phone", physicians.get(selectedPosition).getPhone());
                intent.putExtra("physician_email", physicians.get(selectedPosition).getEmail());
                intent.putExtra("physician_specialty", physicians.get(selectedPosition).getSpecialty());
                startActivity(intent);
            }
        });

        physicianDetailButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PhysicianDetailActivity.class);
                intent.putExtra("physician_first_name", physicians.get(selectedPosition).getFirstName());
                intent.putExtra("physician_last_name", physicians.get(selectedPosition).getLastName());
                intent.putExtra("physician_phone", physicians.get(selectedPosition).getPhone());
                intent.putExtra("physician_email", physicians.get(selectedPosition).getEmail());
                intent.putExtra("physician_specialty", physicians.get(selectedPosition).getSpecialty());
                startActivity(intent);
            }
        });

        }


    @Override
    public void onPhysicianClick(int position) {
        selectedPosition = position;
    }
}
