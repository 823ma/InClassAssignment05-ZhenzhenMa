package com.example.seanma.inclassassignment05_zhenzhenm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class CalendarActivity extends AppCompatActivity {

    String message="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Intent intent = getIntent();
        ArrayList<Event> eventList= (ArrayList<Event>) intent.getSerializableExtra("Event List");

        for (int i=0; eventList.size()>i; i++){
            String Storage = eventList.get(i).toString();
            message= message + Storage + "\n" + "\n";
        }

        TextView finalText = (TextView) findViewById(R.id.display);
        finalText.setText(message);

    }
}
