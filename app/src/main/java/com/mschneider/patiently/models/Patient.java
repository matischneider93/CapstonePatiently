package com.mschneider.patiently.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "patients", foreignKeys = {@ForeignKey(entity = Physician.class,
        parentColumns = "physicianId",
        childColumns = "physicianId")
})
public class Patient {
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    public int patientId;
    public int physicianId;
    @ColumnInfo(name = "first_name")
    public String firstName;
    @ColumnInfo(name = "last_name")
    public String lastName;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "phone")
    public String phone;
    @ColumnInfo(name = "blood_type")
    public String bloodType;
    @ColumnInfo(name = "vaccinated")
    public Boolean vaccinated;
    @ColumnInfo(name = "insurance_provider")
    public String insuranceProvider;

}
