package com.example.seanma.inclassassignment05_zhenzhenm;

import java.io.Serializable;


public class Event implements Serializable {

    String eventName;
    String date;
    String time;
    String note;

// constructor
    public Event (String eventName, String date, String time, String note){
        this.eventName=eventName;
        this.date=date;
        this.time=time;
        this.note=note;
    }

    public String toString(){
        return "Event Name: " + eventName+ "\nDate: " + date + "\nTime: " + time + "\nNote: " + note;
    }

}
