package com.example.imtisal.finalprojectv5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteBook extends AppCompatActivity {
    EditText etBookedMobileNo;
    Button btnDeleteBooked;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_book);
        etBookedMobileNo=(EditText) findViewById(R.id.etBookedMobileNo);
        btnDeleteBooked=(Button) findViewById(R.id.btnDeleteBooked);
        databaseHelper=new DatabaseHelper(this);
        btnDeleteBooked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteData(etBookedMobileNo.getText().toString());
                Toast.makeText(DeleteBook.this, "Data Deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
