package com.example.restfulcalendar.model;

import com.example.restfulcalendar.repositories.EventRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DbInit {

    private final EventRepository eventRepository;


    public DbInit(EventRepository eventRepository){
        this.eventRepository=eventRepository;
    }


    @PostConstruct
    private void postConstruct() {
        ZoneId zone= ZoneId.of("Europe/Moscow");
        List<Event> list=new ArrayList<>();
        list.add( new Event("title1","description1",
                ZonedDateTime.of(2022, 1, 20, 6, 15, 30, 200, zone),
                ZonedDateTime.of(2022, 4, 29, 6, 15, 30, 200, zone),
                "name1"));

        list.add(new Event("title","description",
                ZonedDateTime.of(2022, 3, 7, 6, 15, 30, 200, zone),
                ZonedDateTime.of(2022, 3, 22, 6, 15, 30, 200, zone),
                "name2"));
        list.add(new Event("title","description",
                ZonedDateTime.of(2022, 1, 20, 6, 15, 30, 200, zone),
                ZonedDateTime.of(2022, 1, 29, 6, 15, 30, 200, zone),
                "name1"));

        list.add(new Event("title","description",
                ZonedDateTime.of(2021, 12, 31, 6, 15, 30, 200, zone),
                ZonedDateTime.of(2022, 3, 10, 6, 15, 30, 200, zone),
                "name2"));
        list.add(new Event("title","description",
                ZonedDateTime.of(2022, 2, 17, 6, 15, 30, 200, zone),
                ZonedDateTime.of(2022, 3, 23, 6, 15, 30, 200, zone),
                "name1"));

        list.add(new Event("title2","description2",
                ZonedDateTime.of(2022, 3, 7, 6, 15, 30, 200, zone),
                ZonedDateTime.of(2022, 3, 29, 6, 15, 30, 200, zone),
                "name2"));
        list.add( new Event("title1","description1",
                ZonedDateTime.of(2022, 1, 1, 6, 15, 30, 200, zone),
                ZonedDateTime.of(2022, 1, 29, 6, 15, 30, 200, zone),
                "name1"));

        list.add(new Event("title2","description2",
                ZonedDateTime.of(2022, 3, 1, 6, 15, 30, 200, zone),
                ZonedDateTime.of(2022, 3, 30, 6, 15, 30, 200, zone),
                "name2"));

        list.add( new Event("title1","description1",
                ZonedDateTime.of(2022, 4, 1, 6, 15, 30, 200, zone),
                ZonedDateTime.of(2022, 4, 29, 6, 15, 30, 200, zone),
                "name1"));

        list.add(new Event("title2","description2",
                ZonedDateTime.of(2022, 3, 7, 6, 15, 30, 200, zone),
                ZonedDateTime.of(2022, 5, 10, 6, 15, 30, 200, zone),
                "name2"));
        list.add( new Event("title1","description1",
                ZonedDateTime.of(2022, 4, 20, 6, 15, 30, 200, zone),
                ZonedDateTime.of(2022, 5, 29, 6, 15, 30, 200, zone),
                "name1"));

        list.add(new Event("title2","description2",
                ZonedDateTime.of(2022, 3, 1, 6, 15, 30, 200, zone),
                ZonedDateTime.of(2022, 6, 30, 6, 15, 30, 200, zone),
                "name2"));
        list.add(new Event("title1","description1",
                ZonedDateTime.of(2022, 1, 1, 6, 15, 30, 200, zone),
                ZonedDateTime.of(2022, 10, 29, 6, 15, 30, 200, zone),
                "name1"));

        list.add(new Event("title2","description2",
                ZonedDateTime.of(2022, 3, 7, 6, 15, 30, 200, zone),
                ZonedDateTime.of(2022, 3, 10, 6, 15, 30, 200, zone),
                "name2"));
        list.add(new Event("title1","description1",
                ZonedDateTime.of(2022, 1, 20, 6, 15, 30, 200, zone),
                ZonedDateTime.of(2022, 1, 29, 6, 15, 30, 200, zone),
                "name1"));

        list.add(new Event("title2","description2",
                ZonedDateTime.of(2022, 3, 7, 6, 15, 30, 200, zone),
                ZonedDateTime.of(2022, 3, 10, 6, 15, 30, 200, zone),
                "name2"));

        for (Event event:list
             ) {
            eventRepository.save(event);
        }


    }

}
