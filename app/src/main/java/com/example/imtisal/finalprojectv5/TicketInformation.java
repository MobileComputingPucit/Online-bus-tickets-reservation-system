package com.example.imtisal.finalprojectv5;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.id;

public class TicketInformation extends AppCompatActivity {
      TextView tvBookName,tvBookEmail,tvBookMobileNo,tvBookTravellers,tvTime,tvCat;
    Button btnEdit;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_information);
        tvBookName=(TextView) findViewById(R.id.tvBookName);
        tvBookEmail=(TextView) findViewById(R.id.tvBookEmail);
        tvBookMobileNo=(TextView) findViewById(R.id.tvBookMobileNo);
        tvBookTravellers=(TextView) findViewById(R.id.tvBookTravellers);
        tvTime=(TextView) findViewById(R.id.tvTime);
        tvCat=(TextView) findViewById(R.id.tvCat);
        btnEdit=(Button) findViewById(R.id.btnEdit);
        databaseHelper = new DatabaseHelper(this);
        tvBookName.setText(" ");
        tvBookMobileNo.setText(" ");
        tvBookEmail.setText(" ");
        tvBookTravellers.setText(" ");
        String title = getIntent().getStringExtra("Title");
        String detail = getIntent().getStringExtra("Detail");
        tvCat.setText(title);
        tvTime.setText(detail);

        Cursor cursor = databaseHelper.getData();

        while(cursor.moveToNext())
        {
            tvBookName.setText(cursor.getString(1));
            tvBookMobileNo.setText(cursor.getString(2));
            tvBookEmail.setText(cursor.getString(3));
            tvBookTravellers.setText(cursor.getString(4));

        }
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(TicketInformation.this,EditData.class);
                startActivity(intent);
            }
        });
    }
}
