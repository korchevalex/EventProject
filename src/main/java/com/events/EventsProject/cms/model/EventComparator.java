package com.events.EventsProject.cms.model;

import com.buttercms.model.Page;

import java.util.Comparator;

public class EventComparator implements Comparator<Page<Event>> {
    public int compare(Page<Event> e1, Page<Event> e2) {
        return e2.getFields().getDate().compareTo(e1.getFields().getDate());
    }
}
