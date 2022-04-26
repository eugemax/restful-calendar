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
                50000L,
                "name1"));

        list.add(new Event("title","description",
                ZonedDateTime.of(2022, 3, 7, 6, 15, 30, 200, zone),
                100000L,
                "name2"));
        list.add(new Event("title","description",
                ZonedDateTime.of(2022, 1, 20, 6, 15, 30, 200, zone),
                50000L,

                "name1"));

        list.add(new Event("title","description",
                ZonedDateTime.of(2021, 12, 31, 6, 15, 30, 200, zone),
                30000L,

                "name2"));
        list.add(new Event("title","description",
                ZonedDateTime.of(2022, 2, 17, 6, 15, 30, 200, zone),
                50000L,
                "name1"));

        list.add(new Event("title","description",
                ZonedDateTime.of(2022, 3, 7, 6, 15, 30, 200, zone),
                10000L,
                "name2"));
        list.add( new Event("title","description",
                ZonedDateTime.of(2022, 1, 1, 6, 15, 30, 200, zone),
                200000L,
                "name"));

        list.add(new Event("title","description",
                ZonedDateTime.of(2023, 3, 1, 6, 15, 30, 200, zone),
                25000L,
                "name"));

        list.add( new Event("title","description",
                ZonedDateTime.of(2024, 4, 1, 6, 15, 30, 200, zone),
                50000L,
                "name"));

        list.add(new Event("title","description2",
                ZonedDateTime.of(2020, 3, 7, 6, 15, 30, 200, zone),
                50000L,
                "name"));


        eventRepository.saveAll(list);


    }

}
