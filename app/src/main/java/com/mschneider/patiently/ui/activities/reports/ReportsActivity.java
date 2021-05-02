package com.mschneider.patiently.ui.activities.reports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mschneider.patiently.R;
import com.mschneider.patiently.database.AppDatabase;
import com.mschneider.patiently.models.Patient;
import com.mschneider.patiently.models.Physician;
import com.mschneider.patiently.ui.activities.MainActivity;
import com.mschneider.patiently.ui.adapters.ReportAdapter;

import java.util.ArrayList;
import java.util.List;

public class ReportsActivity extends AppCompatActivity {
    // Array of strings...
    RecyclerView simpleList;
    ArrayList<String> physicianList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        simpleList = (RecyclerView) findViewById(R.id.simpleListView);
        AppDatabase appDatabase = MainActivity.getAppDatabase();



        ReportAdapter adapter = new ReportAdapter(physicianList);
        simpleList.setLayoutManager(new LinearLayoutManager(this));
        simpleList.setAdapter(adapter);

    }
}