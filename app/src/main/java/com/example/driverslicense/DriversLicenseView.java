package com.example.driverslicense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DriversLicenseView extends AppCompatActivity {

    TextView LicenseType,
            FName,
            LName,
            MName,
            NStreet,
            C,
            Muni,
            Pro,
            Ht,
            Wt,
            Nat,
            S,
            Bd;


    String LiType,
            FirstName,
            LastName,
            MiddleName,
            NumStreet,
            City,
            Municipality,
            Province,
            Height,
            Weight,
            Nationality,
            Sex,
            Birthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drivers_license_view);

        LicenseType = findViewById(R.id.LicenseType);
        FName = findViewById(R.id.FirstName);
        LName = findViewById(R.id.LastName);
        MName = findViewById(R.id.MiddleName);
        NStreet = findViewById(R.id.NumStreet);
        C = findViewById(R.id.City);
        Muni = findViewById(R.id.Municipality);
        Pro = findViewById(R.id.Province);
        Ht = findViewById(R.id.H8);
        Wt = findViewById(R.id.W8);
        Nat = findViewById(R.id.Nat);
        S = findViewById(R.id.Seks);
        Bd = findViewById(R.id.Birthday);



        Intent myIntent = getIntent();
        LiType = myIntent.getStringExtra("License");
        FirstName = myIntent.getStringExtra("FirstName");
        LastName = myIntent.getStringExtra("LastName");
        MiddleName = myIntent.getStringExtra("MiddleName");
        NumStreet = myIntent.getStringExtra("NumStreet");
        City = myIntent.getStringExtra("City");
        Municipality = myIntent.getStringExtra("Municipality");
        Province = myIntent.getStringExtra("Province");
        Height = myIntent.getStringExtra("Height");
        Weight = myIntent.getStringExtra("Weight");
        Nationality = myIntent.getStringExtra("Nationality");
        Sex = myIntent.getStringExtra("Sex");
        Birthday = myIntent.getStringExtra("Birthday");






        LicenseType.setText(LiType);
        FName.setText(FirstName);
        LName.setText(LastName);
        MName.setText(MiddleName);
        NStreet.setText(NumStreet);
        C.setText(City);
        Muni.setText(Municipality);
        Pro.setText(Province);
        Ht.setText(Height);
        Wt.setText(Weight);
        Nat.setText(Nationality);
        S.setText(Sex);
        Bd.setText(Birthday);






    }
}