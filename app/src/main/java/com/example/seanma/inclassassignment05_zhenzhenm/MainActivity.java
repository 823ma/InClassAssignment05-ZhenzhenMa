package com.example.seanma.inclassassignment05_zhenzhenm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Event> eventList = new ArrayList<>();
    EditText eventInfoInput;
    EditText eventDateInput;
    EditText eventTimeInput;
    EditText eventNoteInput;
    TextView eventText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventInfoInput = (EditText) findViewById(R.id.type_name);
        eventDateInput = (EditText) findViewById(R.id.type_date);
        eventTimeInput = (EditText) findViewById(R.id.type_time);
        eventNoteInput = (EditText) findViewById(R.id.type_note);
        eventText = (TextView) findViewById(R.id.eventText);

    }

    //Save and display the event info
    public void addSchedule(View view) {
        SharedPreferences sharedPref = getSharedPreferences("Event info", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Event name", eventInfoInput.getText().toString());
        editor.putString("Date", eventDateInput.getText().toString());
        editor.putString("Time", eventTimeInput.getText().toString());
        editor.putString("Notes", eventNoteInput.getText().toString());
        editor.apply();

        String eventName = sharedPref.getString("Event name", "");
        String eventDate = sharedPref.getString("Date", "");
        String eventTime = sharedPref.getString("Time", "");
        String eventNotes = sharedPref.getString("Notes", "");

        eventText.setText(eventName + "\n" + eventDate + "\n" + eventTime + "\n" + eventNotes);

        Event e = new Event(eventName, eventDate, eventTime, eventNotes);
        eventList.add(e);
        eventInfoInput.setText("");
        eventDateInput.setText("");
        eventTimeInput.setText("");
        eventNoteInput.setText("");

        Toast T = Toast.makeText(this, "Event info saved!", Toast.LENGTH_SHORT);
        T.show();

    }

    //Print the saved data on new page

    public void goSchedule(View view) {

        Intent intent = new Intent(this, CalendarActivity.class);
        intent.putExtra("Event List", eventList);
        startActivity(intent);

    }

}
