package com.example.imtisal.finalprojectv5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditData extends AppCompatActivity {
     Button btnSearchBook,btnBookMore,btnDeleteBook,btnChangeBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);
        btnSearchBook=(Button)findViewById(R.id.btnSearchBook);
        btnBookMore=(Button) findViewById(R.id.btnBookMore);
        btnDeleteBook=(Button) findViewById(R.id.btnDeleteBook);
        btnChangeBook=(Button) findViewById(R.id.btnChangeBook);
        btnSearchBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EditData.this,SearchBook.class);
                startActivity(intent);
            }
        });
        btnBookMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EditData.this,Profile.class);
                startActivity(intent);
            }
        });
        btnDeleteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EditData.this,DeleteBook.class);
                startActivity(intent);
            }
        });
        btnChangeBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EditData.this,ChangeBook.class);
                startActivity(intent);
            }
        });
    }
}
