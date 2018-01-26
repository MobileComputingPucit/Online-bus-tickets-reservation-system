package com.example.imtisal.finalprojectv5;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchBook extends AppCompatActivity {
TextView tvBookedName,tvBookedEmail,tvBookedMobileNumber,tvBookedTravellers;
    EditText edittext;
    Button  btnSearchTicket;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_book);
        edittext=(EditText) findViewById(R.id.editText);
        tvBookedName=(TextView) findViewById(R.id.tvBookedName);
        tvBookedEmail=(TextView) findViewById(R.id.tvBookedEmail);
        tvBookedMobileNumber=(TextView) findViewById(R.id.tvBookedMobileNumber);
        tvBookedTravellers=(TextView) findViewById(R.id.tvBookedTravellers);
        btnSearchTicket=(Button) findViewById(R.id.btnSearchTicket);
        databaseHelper=new DatabaseHelper(this);
        btnSearchTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = databaseHelper.getData(edittext.getText().toString());
                tvBookedEmail.setText(" ");
                tvBookedName.setText(" ");
                tvBookedTravellers.setText(" ");
                tvBookedMobileNumber.setText(" ");
                while(cursor.moveToNext())
                {
                    tvBookedName.setText(cursor.getString(1));
                    tvBookedMobileNumber.setText(cursor.getString(2));
                    tvBookedEmail.setText(cursor.getString(3));
                    tvBookedTravellers.setText(cursor.getString(4));

                }

            }
        });

    }
}
