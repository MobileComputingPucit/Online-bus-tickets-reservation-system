package com.example.imtisal.finalprojectv5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChangeBook extends AppCompatActivity {
EditText etChangeName,etChangeEmail,etChangeTravellers,etChangeNumber;
    Button btnUpdate;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_book);
        etChangeName=(EditText) findViewById(R.id.etChangeName);
        etChangeEmail=(EditText) findViewById(R.id.etChangeEmail);
        etChangeTravellers=(EditText)findViewById(R.id.etChangTravellers);
        etChangeNumber=(EditText) findViewById(R.id.etChangeNumber);
        btnUpdate=(Button) findViewById(R.id.btnUpdate);
        databaseHelper=new DatabaseHelper(this);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.updateData(etChangeNumber.getText().toString(),etChangeName.getText().toString(),etChangeEmail.getText().toString(),etChangeTravellers.getText().toString());
            }
        });


    }
}
