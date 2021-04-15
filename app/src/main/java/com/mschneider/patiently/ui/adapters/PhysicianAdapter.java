package com.mschneider.patiently.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mschneider.patiently.R;
import com.mschneider.patiently.databases.PhysicianRepo;
import com.mschneider.patiently.models.Physician;

import java.util.List;

public class PhysicianAdapter  extends RecyclerView.Adapter<PhysicianAdapter.ViewHolder> {
    List<Physician> physiciansList;

    public PhysicianAdapter(List<Physician> physiciansList) {
        this.physiciansList = physiciansList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_physicians,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Physician physician =physiciansList.get(i);

        //  viewHolder.txtid.setText(md.getId());
        viewHolder.physicianIdText.setText(physician.getPhysicianId());
        viewHolder.physicianNameText.setText(physician.getFirstName() + " " + physician.getLastName());
        viewHolder.physicianEmailText.setText(physician.getEmail());
        viewHolder.physicianSpecialityText.setText(physician.getSpeciality());
    }

    @Override
    public int getItemCount() {
        return physiciansList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView physicianIdText,physicianNameText,
                physicianSpecialityText,
                physicianEmailText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            physicianIdText=
                    (TextView)itemView.findViewById(R.id.physicianIdText);
            physicianNameText=
                    (TextView)itemView.findViewById(R.id.physicianNameText);
            physicianEmailText= (TextView)itemView.findViewById(R.id.physicianEmailText);
            physicianSpecialityText=(TextView)itemView.findViewById(R.id.physicianSpecialtyText);
        }
    }
}

