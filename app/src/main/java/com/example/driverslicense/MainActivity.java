package com.example.driverslicense;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Calendar;

//BY: GROUP 6 BSIT-2 BLOCK 1 C072/C073
//Leader: Yap, Fredirick
//Members: Zarate, Cristian
//          Santiago, Acer Christian
//          Flores, Christian

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    static String Ltype, DateOfBirth, Radiobut;



    private static final String TAG = "Main Activity";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    EditText FirstNameEditText,
            LastNameEditText,
            MiddleNameEditText,
            NumStreetEditText,
            CityEditText,
            MunEditText,
            ProvinceEditText,
            HeightEditText,
            WeightEditText,
            NationalityEditText;


    RadioGroup RadioGroup;
    RadioButton RadioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstNameEditText = findViewById(R.id.FirstNameEditText);
        LastNameEditText = findViewById(R.id.LastNameEditText);
        MiddleNameEditText = findViewById(R.id.MiddleNameEditText);
        NumStreetEditText = findViewById(R.id.NumStreetEditText);
        CityEditText = findViewById(R.id.CityEditText);
        MunEditText = findViewById(R.id.MunEditText);
        ProvinceEditText = findViewById(R.id.ProvinceEditText);
        HeightEditText = findViewById(R.id.HeightEditText);
        WeightEditText = findViewById(R.id.WeightEditText);
        NationalityEditText = findViewById(R.id.NationalityEditText);

        RadioGroup = findViewById(R.id.RadioGroup);
        RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.RadioGroup group, int checkedId) {

                RadioButton = (RadioButton) findViewById(checkedId);
                Radiobut = RadioButton.getText().toString();
            }
        });

        Spinner LicenseType = findViewById(R.id.Spinner);
        ArrayAdapter <CharSequence> Adapter = ArrayAdapter.createFromResource(this, R.array.LicenseType, android.R.layout.simple_spinner_item);
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        LicenseType.setAdapter(Adapter);
        LicenseType.setOnItemSelectedListener(this);

        mDisplayDate = (TextView) findViewById(R.id.Date);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                month = month + 1;

                Log.d(TAG, "onDateSet, mm/dd/yyy: "+month+"/"+dayOfMonth+"/"+year);
                String date = month + "/" + dayOfMonth + "/"+year;
                mDisplayDate.setText(date);
                DateOfBirth = date;







            }
        };

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Ltype = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    public void LicenseFunction(View view) {
        Intent LicenseIntent = new Intent(this, DriversLicenseView.class);

        LicenseIntent.putExtra("License",Ltype);
        LicenseIntent.putExtra("FirstName",FirstNameEditText.getText().toString());
        LicenseIntent.putExtra("LastName",LastNameEditText.getText().toString());
        LicenseIntent.putExtra("MiddleName",MiddleNameEditText.getText().toString());
        LicenseIntent.putExtra("NumStreet",NumStreetEditText.getText().toString());
        LicenseIntent.putExtra("City",CityEditText.getText().toString());
        LicenseIntent.putExtra("Municipality",MunEditText.getText().toString());
        LicenseIntent.putExtra("Province",ProvinceEditText.getText().toString());
        LicenseIntent.putExtra("Height",HeightEditText.getText().toString());
        LicenseIntent.putExtra("Weight",WeightEditText.getText().toString());
        LicenseIntent.putExtra("Nationality",NationalityEditText.getText().toString());
        LicenseIntent.putExtra("Sex", Radiobut);
        LicenseIntent.putExtra("Birthday", DateOfBirth.toString());







            if (TextUtils.isEmpty(FirstNameEditText.getText())) {

                Toast.makeText(getApplicationContext(), "Please Enter First Name", Toast.LENGTH_SHORT).show();
                FirstNameEditText.setError("Field Can't be Empty");
                View targetview1 = findViewById(R.id.FirstNameEditText);
                targetview1.getParent().requestChildFocus(targetview1, targetview1);

            } else if (TextUtils.isEmpty(LastNameEditText.getText())) {

                Toast.makeText(getApplicationContext(), "Please Enter Last Name", Toast.LENGTH_SHORT).show();
                LastNameEditText.setError("Field Can't be Empty");
                View targetview = findViewById(R.id.LastNameEditText);
                targetview.getParent().requestChildFocus(targetview, targetview);

            } else if (TextUtils.isEmpty(MiddleNameEditText.getText())) {

                Toast.makeText(getApplicationContext(), "Please Enter Middle Name", Toast.LENGTH_SHORT).show();
                MiddleNameEditText.setError("Field Can't be Empty");
                View targetview = findViewById(R.id.MiddleNameEditText);
                targetview.getParent().requestChildFocus(targetview, targetview);

            } else if (TextUtils.isEmpty(NumStreetEditText.getText())) {

                Toast.makeText(getApplicationContext(), "Please Enter No. & Street", Toast.LENGTH_SHORT).show();
                View targetview = findViewById(R.id.NumStreetEditText);
                targetview.getParent().requestChildFocus(targetview, targetview);
                NumStreetEditText.setError("Field Can't be Empty");

            }
            else if (TextUtils.isEmpty(CityEditText.getText())) {

                Toast.makeText(getApplicationContext(), "Please Enter City", Toast.LENGTH_SHORT).show();
                View targetview = findViewById(R.id.CityEditText);
                targetview.getParent().requestChildFocus(targetview, targetview);
                CityEditText.setError("Field Can't be Empty");

            }
            else if (TextUtils.isEmpty(MunEditText.getText())) {

                Toast.makeText(getApplicationContext(), "Please Enter Municipality", Toast.LENGTH_SHORT).show();
                View targetview = findViewById(R.id.MunEditText);
                targetview.getParent().requestChildFocus(targetview, targetview);
                MunEditText.setError("Field Can't be Empty");

            }

            else if (TextUtils.isEmpty(ProvinceEditText.getText())) {

                Toast.makeText(getApplicationContext(), "Please Enter Municipality", Toast.LENGTH_SHORT).show();
                View targetview = findViewById(R.id.ProvinceEditText);
                targetview.getParent().requestChildFocus(targetview, targetview);
                ProvinceEditText.setError("Field Can't be Empty");

            }else if (TextUtils.isEmpty(HeightEditText.getText())) {

                Toast.makeText(getApplicationContext(), "Please Enter Height", Toast.LENGTH_SHORT).show();
                View targetview = findViewById(R.id.HeightEditText);
                targetview.getParent().requestChildFocus(targetview, targetview);
                HeightEditText.setError("Field Can't be Empty");

            } else if (TextUtils.isEmpty(WeightEditText.getText())) {

                Toast.makeText(getApplicationContext(), "Please Enter Weight", Toast.LENGTH_SHORT).show();
                View targetview = findViewById(R.id.WeightEditText);
                targetview.getParent().requestChildFocus(targetview, targetview);
                WeightEditText.setError("Field Can't be Empty");

            } else if (TextUtils.isEmpty(NationalityEditText.getText())) {

                Toast.makeText(getApplicationContext(), "Please Enter Nationality", Toast.LENGTH_SHORT).show();
                View targetview = findViewById(R.id.NationalityEditText);
                targetview.getParent().requestChildFocus(targetview, targetview);
                NationalityEditText.setError("Field Can't be Empty");

            }

            else if (TextUtils.isEmpty(DateOfBirth)) {

                Toast.makeText(getApplicationContext(), "Please Enter Birth Date", Toast.LENGTH_SHORT).show();
                View targetview = findViewById(R.id.Date);
                targetview.getParent().requestChildFocus(targetview, targetview);

            }
            else if(RadioGroup.getCheckedRadioButtonId()==-1){

                Toast.makeText(getApplicationContext(), "Please Choose Sex", Toast.LENGTH_SHORT).show();
                View targetview = findViewById(R.id.RadioGroup);
                targetview.getParent().requestChildFocus(targetview, targetview);

            }




            else {





                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

                builder.setTitle("Form Submission");
                builder.setMessage("Do you want to display the Driver's License?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (Ltype.equals("Please Select Type. . .")) {


                            Toast.makeText(getApplicationContext(), "Please Select License Type", Toast.LENGTH_LONG).show();
                            View targetview = findViewById(R.id.LicenseTitle);
                            targetview.getParent().requestChildFocus(targetview, targetview);


                        } else
                            startActivity(LicenseIntent);

                    }

                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                });

                builder.show();


            }





        }
    }

