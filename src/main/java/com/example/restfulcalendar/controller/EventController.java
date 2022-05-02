package com.example.restfulcalendar.controller;


import com.example.restfulcalendar.model.Event;
import com.example.restfulcalendar.service.EventService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/api/")
public class EventController {


    private final EventService eventService;

    private final EventModelAssembler assembler;

    EventController( EventService eventService, EventModelAssembler assembler) {

         this.eventService = eventService;
         this.assembler= assembler;

    }


        @GetMapping("events")
        CollectionModel<EntityModel<Event>> all() {
            List<EntityModel<Event>> events= eventService.findAll().stream()
                    .map(assembler::toModel)
                    .collect(Collectors.toList());

            return CollectionModel.of(events, linkTo(methodOn(EventController.class).all()).withSelfRel());
        }



        @PostMapping("events")
        public ResponseEntity<Event> addEvent( @Valid @RequestBody Event event) {
            Event savedEvent=eventService.createEvent(event);
               return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
        }




        @GetMapping("events/{id}")
        EntityModel<Event> one(@PathVariable Long id) {

         Event event= eventService.findByIdentificationNumber(id);
            return assembler.toModel(event);
        }

        @PutMapping("events/{id}")
        Event replaceEvent(@RequestBody Event event, @PathVariable Long id) {

            return eventService.replaceEvent(event, id);
        }

        @DeleteMapping("events/{id}")
        void deleteEvent(@PathVariable Long id) {
            eventService.deleteById(id);
        }


        @GetMapping("events/filters/by_date/{year}")
        CollectionModel<EntityModel<Event>> findByYear(@PathVariable Integer year) {
            List<EntityModel<Event>> events = eventService.findByYear(year)
                    .stream()
                    .map(assembler::toModel)
                    .collect(Collectors.toList());

            return CollectionModel.of(events, linkTo(methodOn(EventController.class).all()).withSelfRel());
        }


    @GetMapping("events/filters/by_date/{year}/{month}")
    CollectionModel<EntityModel<Event>> findByMonth(@PathVariable Integer year,@PathVariable Integer month) {
        List<EntityModel<Event>> events = eventService.findByMonth(year,month).stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(events, linkTo(methodOn(EventController.class).all()).withSelfRel());
    }

    @GetMapping("events/filters/by_date/{year}/{month}/{day}")
    CollectionModel<EntityModel<Event>> findByDate(@PathVariable Integer year,@PathVariable Integer month, @PathVariable Integer day) {
        List<EntityModel<Event>> events = eventService.findByDate(year,month,day).stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(events, linkTo(methodOn(EventController.class).all()).withSelfRel());
    }




    }


