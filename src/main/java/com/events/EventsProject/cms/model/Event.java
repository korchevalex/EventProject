package com.events.EventsProject.cms.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
public class Event implements Comparable<Event>{
    private String title;
    private LocalDateTime date;
    private String address;
    private String image;
    private String text;
    private String shortText;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = LocalDateTime.parse(date);
    }

    public String getFormattedDate() {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    @Override
    public int compareTo(Event e) {
        return getDate().compareTo(e.getDate());
    }
}
