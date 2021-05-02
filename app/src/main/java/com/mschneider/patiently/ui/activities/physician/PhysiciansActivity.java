package com.mschneider.patiently.ui.activities.physician;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.mschneider.patiently.R;
import com.mschneider.patiently.database.AppDatabase;
import com.mschneider.patiently.database.repo.PhysicianRepo;
import com.mschneider.patiently.database.view_models.PhysicianViewModel;
import com.mschneider.patiently.models.Physician;
import com.mschneider.patiently.ui.activities.MainActivity;
import com.mschneider.patiently.ui.adapters.PhysicianAdapter;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class PhysiciansActivity extends AppCompatActivity {
    private RecyclerView physiciansRecyclerView;
    private List<String> physiciansList = new ArrayList<>();
    private PhysicianViewModel physicianViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_physicians);
            AppDatabase appDatabase = MainActivity.getAppDatabase();
            List<Physician> physicians = appDatabase.physicianDao().getAllPhysicians();
            for (Physician physician : physicians){
                physiciansList.add(physician.getFirstName());
            }


            physiciansRecyclerView = findViewById(R.id.physiciansRecyclerView);
            physiciansRecyclerView.setHasFixedSize(true);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            physiciansRecyclerView.setLayoutManager(layoutManager);
            physiciansRecyclerView.setAdapter(new PhysicianAdapter(physiciansList));



        }

    }
