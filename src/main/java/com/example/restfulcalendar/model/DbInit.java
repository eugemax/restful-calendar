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
                1000L,
                "name1"));

        list.add(new Event("title","description",
                ZonedDateTime.of(2022, 2, 1, 0, 15, 30, 200, zone),
                1500L,
                "name2"));
        list.add(new Event("title","description",
                ZonedDateTime.of(2022, 3, 1, 0, 15, 30, 200, zone),
                3000L,

                "name1"));

        list.add(new Event("title","description",
                ZonedDateTime.of(2021, 12, 31, 0, 15, 30, 200, zone),
                3000L,

                "name2"));
        list.add(new Event("title","description",
                ZonedDateTime.of(2022, 4, 1, 0, 15, 30, 200, zone),
                4000L,
                "name1"));

        list.add(new Event("title","description",
                ZonedDateTime.of(2022, 5, 1, 0, 15, 30, 200, zone),
                4000L,
                "name2"));
        list.add( new Event("title","description",
                ZonedDateTime.of(2022, 6, 1, 6, 15, 30, 200, zone),
                5000L,
                "name"));

        list.add(new Event("title","description",
                ZonedDateTime.of(2023, 1, 1, 6, 15, 30, 200, zone),
                6000L,
                "name"));

        list.add( new Event("title","description",
                ZonedDateTime.of(2024, 1, 1, 6, 15, 30, 200, zone),
                5000L,
                "name"));

        list.add(new Event("title","description2",
                ZonedDateTime.of(2025, 3, 7, 6, 15, 30, 200, zone),
                50000L,
                "name"));


        eventRepository.saveAll(list);


    }

}
