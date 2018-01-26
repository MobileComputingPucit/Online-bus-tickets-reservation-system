package com.example.imtisal.finalprojectv5;



import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Profile extends AppCompatActivity {
    RadioGroup g1;
    Spinner spinner1, spinner2;
    ArrayAdapter<CharSequence> adapter;
    EditText  etName,etEmail,etMobileNumber,etTravellers;
    Button btnSave;
    private DatabaseHelper databaseHelper;

    private static final String TAG = "Profile";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        btnSave=(Button) findViewById(R.id.btnSave) ;
        databaseHelper = new DatabaseHelper(this);
        g1=(RadioGroup)findViewById(R.id.G1) ;
        etName=(EditText)findViewById(R.id.etName) ;
        etEmail=(EditText)findViewById(R.id.etEmail) ;
        etMobileNumber=(EditText)findViewById(R.id.etMobileNumber) ;
        etTravellers=(EditText)findViewById(R.id.etTravellers) ;


        g1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.R1)
                {
                    Toast.makeText(Profile.this,"One Way", Toast.LENGTH_SHORT).show();
                }
                if(checkedId==R.id.R2)
                {
                    Toast.makeText(Profile.this,"Round Way", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mDisplayDate = (TextView) findViewById(R.id.tvDate);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Profile.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        adapter = ArrayAdapter.createFromResource(Profile.this, R.array.city_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "is selected", Toast.LENGTH_LONG).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        adapter = ArrayAdapter.createFromResource(Profile.this, R.array.city_names2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " is selected", Toast.LENGTH_LONG).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = databaseHelper.insertData(etName.getText().toString(), Integer.parseInt(etMobileNumber.getText().toString()),
                        etEmail.getText().toString(),Integer.parseInt(etTravellers.getText().toString()));
                if(result){
                    Toast.makeText(Profile.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(Profile.this,BusesList.class);
                startActivity(intent);
                }
                else
                    Toast.makeText(Profile.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
            }

        });
    }
}


























