package com.example.imtisal.finalprojectv5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.imtisal.finalprojectv5.android.adapter.CustomListViewAdapter_7;
import com.example.imtisal.finalprojectv5.android.beans.RowItem_7;


import java.util.ArrayList;
import java.util.List;

public class BusesList extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public static final String[] titles = new String[]{"Daewoo","Volvo","Niazi","Daewoo","Volvo","Niazi","Daewoo","Volvo","Niazi"};

    public static final String[] descriptions = new String[]{"Catagery:Luxury  Time: 09:00 ","Catagery: Luxury   Time: 10:00 ","Catagery: Luxury  Time: 11:00 ","Catagery: A.C  Time: 10:00 ","Catagery: A.C   Time: 11:00 ","Catagery: A.C  Time: 12:00 ","Catagery:Economy  Time: 11:00 ","Catagery: Economy   Time: 12:00 ","Catagery: Economy  Time: 1:00 "};

    public static final Integer[] images = {R.drawable.daewoo_logo,R.drawable.volvologo,R.drawable.niazilogo,R.drawable.daewoo_logo,R.drawable.volvologo,R.drawable.niazilogo,R.drawable.daewoo_logo,R.drawable.volvologo,R.drawable.niazilogo};

    ListView listView;
    List<RowItem_7> rowItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buses_list);

        rowItems = new ArrayList<RowItem_7>();
        for (int i = 0; i < titles.length; i++) {
            RowItem_7 item = new RowItem_7(images[i], titles[i], descriptions[i]);
            rowItems.add(item);
        }

        listView = (ListView) findViewById(R.id.list_7);
        CustomListViewAdapter_7 adapter = new CustomListViewAdapter_7(this,
                R.layout.listlayout, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {


        if (position == 0) {
            Intent intent = new Intent(BusesList.this,TicketInformation.class);
            intent.putExtra("Title", titles[0]);
            intent.putExtra("Detail", descriptions[0]);
            startActivity(intent);
        }
        if (position == 1) {
            Intent intent = new Intent(BusesList.this,TicketInformation.class);
            intent.putExtra("Title", titles[1]);
            intent.putExtra("Detail", descriptions[1]);
            startActivity(intent);
        }
        if (position == 2) {
            Intent intent = new Intent(BusesList.this,TicketInformation.class);
            intent.putExtra("Title", titles[2]);
            intent.putExtra("Detail", descriptions[2]);
            startActivity(intent);
        }
        if (position == 3) {
            Intent intent = new Intent(BusesList.this,TicketInformation.class);
            intent.putExtra("Title", titles[3]);
            intent.putExtra("Detail", descriptions[3]);
            startActivity(intent);
        }
        if (position == 4) {
            Intent intent = new Intent(BusesList.this,TicketInformation.class);
            intent.putExtra("Title", titles[4]);
            intent.putExtra("Detail", descriptions[4]);
            startActivity(intent);
        }
        if (position == 5) {
            Intent intent = new Intent(BusesList.this,TicketInformation.class);
            intent.putExtra("Title", titles[5]);
            intent.putExtra("Detail", descriptions[5]);
            startActivity(intent);
        }
        if (position == 6) {
            Intent intent = new Intent(BusesList.this,TicketInformation.class);
            intent.putExtra("Title", titles[6]);
            intent.putExtra("Detail", descriptions[6]);
            startActivity(intent);
        }
        if (position == 7) {
            Intent intent = new Intent(BusesList.this,TicketInformation.class);
            intent.putExtra("Title", titles[7]);
            intent.putExtra("Detail", descriptions[7]);
            startActivity(intent);
        }
        if (position == 8) {
            Intent intent = new Intent(BusesList.this,TicketInformation.class);
            intent.putExtra("Title", titles[8]);
            intent.putExtra("Detail", descriptions[8]);
            startActivity(intent);
        }
    }


}
