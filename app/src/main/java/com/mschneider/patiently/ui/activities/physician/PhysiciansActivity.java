package com.mschneider.patiently.ui.activities.physician;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mschneider.patiently.R;
import com.mschneider.patiently.database.repo.PhysicianRepo;
import com.mschneider.patiently.models.Physician;
import com.mschneider.patiently.ui.activities.MainActivity;
import com.mschneider.patiently.ui.adapters.PhysicianAdapter;

import java.util.List;

public class PhysiciansActivity extends AppCompatActivity {
    private RecyclerView physiciansRecyclerView;
    private Button physicianAddButton, physicianEditButton,
    physicianDeleteButton,physicianDetailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        physiciansRecyclerView = findViewById(R.id.physiciansRecyclerView);
        physicianAddButton = findViewById(R.id.physicianAddButton);
        physicianEditButton = findViewById(R.id.physicianEditButton);
        physicianDeleteButton = findViewById(R.id.physicianDeleteButton);
        physicianDetailButton = findViewById(R.id.physicianDetailButton);
        setContentView(R.layout.activity_physicians);
        physiciansRecyclerView.setHasFixedSize(true);
        physiciansRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        PhysicianRepo repo = new PhysicianRepo(getApplication());
        repo.getAllPhysicians();
        physiciansRecyclerView.setAdapter(new PhysicianAdapter());
        getData();



        physicianAddButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        physicianEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

            }
        });


        
    }

    private void getData() {
        class GetData extends AsyncTask<Void,Void,List<Physician>> {

            @Override
            protected List<Physician> doInBackground(Void... voids) {
                List<Physician>myDataLists=
                        (List<Physician>) MainActivity.appDatabase.physicianDao().getAllPhysicians();

                return myDataLists;

            }

            @Override
            protected void onPostExecute(List<Physician> physiciansList) {
                PhysicianAdapter adapter=new PhysicianAdapter(physiciansList);
                physiciansRecyclerView.setAdapter(adapter);
                super.onPostExecute(physiciansList);
            }
        }
        GetData gd=new GetData();
        gd.execute();
    }
}