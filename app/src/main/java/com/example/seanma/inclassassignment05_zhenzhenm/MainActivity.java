package com.example.seanma.inclassassignment05_zhenzhenm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Event> eventList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void addCalendar(View view) {
        EditText nameEvent = (EditText) findViewById(R.id.type_name);
        EditText inputDate = (EditText) findViewById(R.id.type_date);
        EditText inputTime = (EditText) findViewById(R.id.type_time);
        EditText inputNote = (EditText) findViewById(R.id.type_note);

        String sNameEvent = nameEvent.getText().toString();
        String sInputDate = inputDate.getText().toString();
        String sInputTime = inputTime.getText().toString();
        String sInputNote = inputNote.getText().toString();

        Event e= new Event(sNameEvent, sInputDate, sInputTime, sInputNote);
        eventList.add(e);

        nameEvent.setText(null);
        inputDate.setText(null);
        inputTime.setText(null);
        inputNote.setText(null);

        Toast T = Toast.makeText(this, "Event info saved!", Toast.LENGTH_SHORT);
        T.show();

    }

    public void goCalendar(View view) {
        Intent intent = new Intent (this, CalendarActivity.class);
        intent.putExtra("Event List", eventList);
        startActivity(intent);

    }
}
