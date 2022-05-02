package com.example.restfulcalendar.service;

import com.example.restfulcalendar.exceptions.AllocatedTimeException;
import com.example.restfulcalendar.exceptions.EventNotFoundException;
import com.example.restfulcalendar.model.Event;
import com.example.restfulcalendar.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;


@Service
public class EventService {

    private  final EventRepository eventRepository;


    public EventService(EventRepository eventRepository){
        this.eventRepository=eventRepository;
    }


    public Event createEvent(Event event) {
    if( isTimeFree( event) )
                  return eventRepository.save(event);
    else throw new AllocatedTimeException(event.getId());
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

        if( isTimeFree( event) ) {
            return eventRepository.findById(id)
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
        }else
            throw new AllocatedTimeException(id);
    }

    public void deleteById(Long id){
        eventRepository.deleteById(id);
    }

    private   boolean isTimeFree(Event event){
        ZonedDateTime start=event.getStartDate();
        ZonedDateTime end=start.plusMinutes(event.getMinutesDuration());
        List<Event> list= eventRepository.findByRange(start.getYear(),start.getMonthValue(),start.getDayOfMonth(),start.getHour(),start.getMinute(),
                end.getYear(), end.getMonthValue(), end.getDayOfMonth(), end.getHour(), end.getMinute());

        return list.isEmpty();
    }


}

