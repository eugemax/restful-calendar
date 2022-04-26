package com.example.restfulcalendar.service;

import com.example.restfulcalendar.exceptions.EventNotFoundException;
import com.example.restfulcalendar.model.Event;
import com.example.restfulcalendar.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventService {

    private  final EventRepository eventRepository;


    public EventService(EventRepository eventRepository){
        this.eventRepository=eventRepository;
    }


    public Event createEvent(Event event) {

                  return eventRepository.save(event);

    }


    public List<Event>findAll(){

      return   eventRepository.findAll();

    }

    public List<Event>findByYear(Integer year){

        return   eventRepository.findByYear(year);

    }

    public List<Event>findByMonth(Integer year, Integer month){

        return   eventRepository.findByMonth(year,month);

    }

    public List<Event>findByDate(Integer year, Integer month, Integer day){

        return   eventRepository.findByDate(year, month, day);

    }


    public Event findByIdentificationNumber(Long id){
       return eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
    }


    public Event replaceEvent(Event event, Long id){
        return  eventRepository.findById(id)
                .map(e -> {
                    e.setTitle(event.getTitle());
                    e.setDescription(event.getDescription());
                    e.setStart(event.getStartDate());
                    e.setMinutesDuration(event.getMinutesDuration());
                    e.setName(event.getName());
                    return eventRepository.save(e);
                })
                .orElseGet(() -> {
                    event.setId(id);
                    return eventRepository.save(event);
                });
    }

    public void deleteById(Long id){
        eventRepository.deleteById(id);
    }


}

