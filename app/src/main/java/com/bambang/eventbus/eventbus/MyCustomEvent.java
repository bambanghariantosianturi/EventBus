package com.bambang.eventbus.eventbus;

/**
 * Created by bambanghs on 5/14/2017.
 */

public class MyCustomEvent {

    public int getEventAngka() {
        return eventAngka;
    }

    public void setEventAngka(int eventAngka) {
        this.eventAngka = eventAngka;
    }

    public String getEventText() {
        return eventText;
    }

    public void setEventText(String eventText) {
        this.eventText = eventText;
    }

    private String eventText;
    private int eventAngka;

}
