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

        eventList = new ArrayList<>();

        String key = getString(R.string.event_name);

        SharedPreferences sharedPref = getPreferences(MODE_PRIVATE);
        String eventString = sharedPref.getString(key, getString(R.string.event_name));

        eventText = (TextView) findViewById(R.id.eventText);
        eventText.setText("Added, " + eventString + "!");


    }




    public void addSchedule(View view) {
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


        Toast T = Toast.makeText(this, "Event info saved!", Toast.LENGTH_SHORT);
        T.show();

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.event_name), sNameEvent);
        editor.commit();

        nameEvent.setText("");
        inputDate.setText("");
        inputTime.setText("");
        inputNote.setText("");

        TextView eventDisplay = (TextView) findViewById(R.id.eventText);
        String msg ="Added Event: "+ sNameEvent+"\n"
                    + sInputDate+"\n"
                +sInputTime+"\n"
                +sInputNote;
        eventDisplay.setText(msg);
    }


    //Print the saved data on new page

    public void goSchedule(View view) {

        Intent intent = new Intent(this, CalendarActivity.class);
        intent.putExtra("Event List", eventList);
        startActivity(intent);

    }

}
